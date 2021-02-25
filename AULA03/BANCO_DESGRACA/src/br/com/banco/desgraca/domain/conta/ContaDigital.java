package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.exception.ContaDigitalValorMinimoException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;



import java.text.DecimalFormat;


public class ContaDigital extends ContasBancarias {

    public ContaDigital(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeContaCorrente, Double saldo) {
        super(tiposDeContaBancaria, instituicaoBancaria, numeroDeContaCorrente, saldo);
    }


    String contaDigital = TiposDeContaBancaria.CONTA_DIGITAL.getTipoDeConta() + getInstituicaoBancaria() + " " + getNumeroDeConta();

    public Double consultarSaldo() {
        return super.consultarSaldo();
    }

    @Override
    public void depositar(Double valor) {
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
        System.out.println(TipoTransacao.DEPOSITO.getTipoTransacao() + valorFormatado + " na " + contaDigital);
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void sacar(Double valor) {
        Boolean temSaldo = valor < getSaldo();
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);


        if (valor < 10) {
            throw new ContaDigitalValorMinimoException("Operação inválida — valor mínimo para saque é de " + DecimalFormat.getCurrencyInstance().format(TiposDeContaBancaria.CONTA_DIGITAL.getValorMinimoSaque()));
        } else if (temSaldo) {
            System.out.println(TipoTransacao.SAQUE.getTipoTransacao() + valorFormatado + " da " + contaDigital);
            setSaldo(getSaldo() - valor);
            Data.getDataTransacao();
        } else {
            throw new SaldoInsuficienteException("Operação inválida — Saldo insuficiente para realizar a operação");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        Boolean temSaldo = valor < getSaldo();
        if (!temSaldo) {
            throw new SaldoInsuficienteException("Operação inválida — Saldo insuficiente para realizar a operação");
        } else {
            String valorFormatado = DecimalFormat.getCurrencyInstance().format(valor);
            System.out.println(TipoTransacao.TRANSFERENCIA_PARA_MESMO_BANCO.getTipoTransacao() + valorFormatado + " da " + contaDigital + " para a " + contaDestino);
            setSaldo(getSaldo() - valor);
            Data.getDataTransacao();
        }
    }

        @Override
        public String toString () {
            return contaDigital;
        }
}
