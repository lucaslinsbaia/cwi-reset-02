package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class ContasBancarias implements ContaBancaria{

    private InstituicaoBancaria instituicaoBancaria;
    private Integer numeroDeConta;
    private Double saldo;
    private TiposDeContaBancaria tiposDeContaBancaria;

    public ContasBancarias(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeConta, Double saldo) {
        this.tiposDeContaBancaria = tiposDeContaBancaria;
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroDeConta = numeroDeConta;
        this.saldo = saldo;
    }

    public Integer getNumeroDeConta() {
        return numeroDeConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double setSaldo(Double saldo) {
        this.saldo = saldo;
        return saldo;
    }

    public String getContaDestino(InstituicaoBancaria instituicaoBancaria, TiposDeContaBancaria tiposDeContaBancaria, Integer numeroDeContaCorrente) {
        return tiposDeContaBancaria.getTipoDeConta() + instituicaoBancaria + " " + numeroDeContaCorrente;
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
/*      String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        System.out.println(TipoTransacao.DEPOSITO.getTipoTransacao() + valorFormatado + " na " + TiposDeContaBancaria.valueOf());
        setSaldo(getSaldo() + valor);
        Data.getDataTransacao();
 */

    }

    @Override
    public void sacar(Double valor) {
        if (valor >= getSaldo()) {
            setSaldo(getSaldo() - valor);
            Data.getDataTransacao();
        } else {
            throw new SaldoInsuficienteException("647393");
        }


    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(contaDestino.getInstituicaoBancaria().equals(this.instituicaoBancaria.getInstituicaoBancaria())) {
//            TipoTransacao.TRANSFERENCIA_PARA_MESMO_BANCO.getTipoTransacao();
            System.out.println("Transferindo valor para a mesma instituição Bancária");
        } else {
            System.out.println("Transferindo valor para outra instituição Bancária");
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    @Override
    public String toString() {
        return "Contas Bancárias";
    }


    }
