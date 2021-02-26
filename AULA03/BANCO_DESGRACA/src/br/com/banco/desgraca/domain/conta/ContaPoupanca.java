package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ContaPoupancaException;
import br.com.banco.desgraca.exception.ValorMinimoException;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeConta, Double saldo) {
        super(tiposDeContaBancaria, instituicaoBancaria, numeroDeConta, saldo);
        if (instituicaoBancaria.getInstituicaoBancaria().equals("Nubank")) {
            throw new ContaPoupancaException("Operação não permitida — infelizmente, não contamos com este tipo de conta aqui no Nubank!");
        }
    }

    @Override
    public void sacar(Double valor) {
        if(valor < 50) {
            throw new ValorMinimoException("Transação não permitida — valor mínimo para saque é de R$ 50,00");
        } else {
            super.sacar(valor);

        }



    }
}
