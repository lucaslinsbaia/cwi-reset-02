
package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.exception.ContaCorrenteValorException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;

public class ContaCorrente extends ContasBancarias {

    public ContaCorrente(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeConta, Double saldo) {
        super(tiposDeContaBancaria, instituicaoBancaria, numeroDeConta, saldo);
    }


    Boolean transferindoParaOutroBanco = TipoTransacao.TRANSFERENCIA_PARA_OUTROS_BANCOS.getExecutar();
    String contaCorrente = TiposDeContaBancaria.CONTA_CORRENTE.getTipoDeConta() + getInstituicaoBancaria() + " " + getNumeroDeConta() + ".";

    @Override
    public void depositar(Double valor) {


        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        System.out.println(TipoTransacao.DEPOSITO.getTipoTransacao() + valorFormatado + " na " + contaCorrente);
        setSaldo(getSaldo() + valor);
        Data.getDataTransacao();
    }

    @Override
    public void sacar(Double valor) {
        Boolean temSaldo = valor < getSaldo();
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);


        if (valor % 5 != 0) {
            throw new ContaCorrenteValorException("Operação proibida — valor do saque deve ser múltiplo de R$ 5");

        } else if (temSaldo) {
            Double calculaSaldo = getSaldo() - valor;
            System.out.println(TipoTransacao.SAQUE.getTipoTransacao() + valorFormatado + " da " + contaCorrente);
            setSaldo(calculaSaldo);
            Data.getDataTransacao();
        } else {
            throw new SaldoInsuficienteException("Operação proibida — saldo insuficiente para realizar a operação");
        }
    }

    @Override
    public Double consultarSaldo() {
        return getSaldo();

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        super.transferir();
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Operação proibida — saldo insuficiente para realizar a operação");
        }
            if (transferindoParaOutroBanco) {
                Double calculoDaTaxa = (valor * TiposDeContaBancaria.CONTA_CORRENTE.getTaxaTransferenciaOutroBanco());
                System.out.println(TipoTransacao.TRANSFERENCIA_PARA_OUTROS_BANCOS.getTipoTransacao() + valorFormatado
                        + " da " + contaCorrente + " para a" + contaDestino);

                setSaldo(getSaldo() - calculoDaTaxa - valor);
                Data.getDataTransacao();

            } else {
                Double calculoDaTaxa = (valor * TiposDeContaBancaria.CONTA_CORRENTE.getTaxaTransferenciaMesmoBanco());
                System.out.println(TipoTransacao.TRANSFERENCIA_PARA_MESMO_BANCO.getTipoTransacao() + valorFormatado
                        + " da " + contaCorrente + " para a" + contaDestino);
                setSaldo(getSaldo() - calculoDaTaxa - valor);
                System.out.println("O valor da taxa para esta operação é de :" + DecimalFormat.getCurrencyInstance().format(calculoDaTaxa));
                Data.getDataTransacao();
            }


    }


        @Override
        public String toString () {
            return contaCorrente;
        }
    }