package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.exception.DataInvalidaException;
import br.com.banco.desgraca.exception.DepositoInvalidoException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class Conta implements ContaBancaria{

    private InstituicaoBancaria instituicaoBancaria;
    private Integer numeroDeConta;
    private Double saldo;
    private TiposDeContaBancaria tiposDeContaBancaria;
    private ContaBancaria contaDestino;
    private List<Transacao> transacao;

    public Conta(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeConta, Double saldo) {
        this.tiposDeContaBancaria = tiposDeContaBancaria;
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroDeConta = numeroDeConta;
        this.saldo = saldo;
        this.transacao = new ArrayList<>();

    }


    public Integer getNumeroDeConta() {
        return numeroDeConta;
    }

    public Double getSaldo() {
        return saldo;
    }


    //SETTER
    public Double setSaldo(Double saldo) {
        this.saldo = saldo;
        return saldo;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }


    @Override
    public Double consultarSaldo() {
        return getSaldo();
    }

    @Override
    public void depositar(Double valor) {
        if(valor <= 0) {
            throw new DepositoInvalidoException("Operação inválida — valor para depósito deve ser maior que 0.");
        }
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        Double valorAposDeposito = (getSaldo() + valor);
        System.out.println(TipoTransacao.DEPOSITO.getTipoTransacao() + valorFormatado + " na " + this.toString());
        setSaldo(valorAposDeposito);
        Data.getDataTransacao();
    }

    @Override
    public void sacar(Double valor) {
        Boolean temSaldo = (valor > 0);
        Boolean podeSacar = (valor < getSaldo());
        Double valorAposSaque = getSaldo() - valor;
        Double taxaDeSaque = tiposDeContaBancaria.getTaxaSaque();
        Double valorTaxaDeSaque = taxaDeSaque * valor;
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        if (temSaldo && podeSacar) {
            transacao.add(new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
            setSaldo(valorAposSaque - valorTaxaDeSaque);
            System.out.println(TipoTransacao.SAQUE.getTipoTransacao() + valorFormatado + " da " + this.toString());
            System.out.println("Valor da taxa de saque: " + DecimalFormat.getCurrencyInstance().format(valorTaxaDeSaque));
        } else {
            throw new SaldoInsuficienteException("Transação não permitida — saldo Insuficiente para realizar a operação");
        }

    }


    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        Boolean temSaldo = valor > 0;
        Boolean podeTransferir = valor < getSaldo();
        Double calculaSaldoOrigem = getSaldo() - valor;
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        Double taxaTransferenciaOutroBanco = getSaldo() - (TiposDeContaBancaria.CONTA_POUPANCA.getTaxaTransferenciaOutroBanco() * valor);
        Double taxaTransferenciaMesmoBanco = getSaldo() - (TiposDeContaBancaria.CONTA_POUPANCA.getTaxaTransferenciaOutroBanco() * valor);
        if(temSaldo && podeTransferir) {
            if (instituicaoBancaria.getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria())) {
                transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA_PARA_MESMO_BANCO, Data.getDataTransacao(), valor));
                System.out.println("Transferindo o valor de " + valorFormatado + " para a " + contaDestino.toString());
                this.setSaldo(calculaSaldoOrigem - taxaTransferenciaMesmoBanco);
                this.consultarSaldo();
                contaDestino.depositar(valor);
                contaDestino.consultarSaldo();
            } else {
                transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA_PARA_OUTROS_BANCOS, Data.getDataTransacao(), valor));
                System.out.println("Transferindo o valor de " + valorFormatado + " para a " + contaDestino.toString());
                this.setSaldo(calculaSaldoOrigem - taxaTransferenciaOutroBanco);
                this.consultarSaldo();
                contaDestino.depositar(valor);
                contaDestino.consultarSaldo();
            }

        } else {
            throw new SaldoInsuficienteException("Operação proibida — saldo insuficiente para realizar a operação");
        }


    }
    /**
     * Exibe o extrato da conta para o período informado.
     *   Se não for passada a data de início, deve filtrar somente pela data de fim.
     *   Se não for passada a data de fim, deve filtrar somente pela data de início.
     *   Se não for passada nenhuma data, deve exibir todos os registros.
     *
     * É exibido o símobolo "+" para indicar entrada na conta e "-" para indicar saída da conta. Ex. de extrato:
     *
     * <code>
     *     ----- EXTRATO CONTA DIGITAL NUBANK 12345
     *     +   R$ 100,00   01/07/2020
     *     +    R$ 50,00   06/07/2020
     *     -    R$ 10,00   11/04/2020
     *     -----
     * </code>
     *
     * @param inicio Data de início para filtro. Pode ser null.
     * @param fim Data de fim para filtro. Pode ser null.
     */
    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("---- EXTRATO " + this.toString().toUpperCase(Locale.ROOT));
        if (fim.isBefore(inicio)) {
            throw new DataInvalidaException("Parâmeteros incorretos — data final precisa ser posterior à data inicial");
        } else {
            for (Transacao transacao : transacao) {
                System.out.println(transacao.getTipoTransacao().getSinalTransacao() + "   " + transacao.getValorTransacao() +"   " + transacao.getDataTransacao());
            }
        }


    }

    @Override
    public String toString() {
        return tiposDeContaBancaria.getTipoDeConta() +"" + instituicaoBancaria.getInstituicaoBancaria() + " " + numeroDeConta;
    }


    }
