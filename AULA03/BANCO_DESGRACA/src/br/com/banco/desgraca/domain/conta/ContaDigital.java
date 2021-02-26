package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ContaDigitalException;
import br.com.banco.desgraca.exception.ValorMinimoException;


public class ContaDigital extends Conta {

    public ContaDigital(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeContaCorrente, Double saldo) {
        super(tiposDeContaBancaria, instituicaoBancaria, numeroDeContaCorrente, saldo);
        if (instituicaoBancaria.equals(InstituicaoBancaria.BANCO_DO_BRASIL) || instituicaoBancaria.equals(InstituicaoBancaria.CAIXA)) {
            throw new ContaDigitalException("Não é possível criar contas Digitais nesta instituição.");
        }

    }

    @Override
    public void sacar(Double valor) {
        if (valor < 10) {
            throw new ValorMinimoException("Transação não permitida — valor mínimo para saques é de R$ 10,00");
        } else {
            super.sacar(valor);
        }
    }



}
