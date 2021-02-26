
package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;

public class ContaCorrente extends Conta {

    public ContaCorrente(TiposDeContaBancaria tiposDeContaBancaria, InstituicaoBancaria instituicaoBancaria, Integer numeroDeConta, Double saldo) {
        super(tiposDeContaBancaria, instituicaoBancaria, numeroDeConta, saldo);

    }

    @Override
    public void sacar(Double valor) {
        if (valor%5 != 0) {
            throw new SaqueException("Transação negada — valores de saque devem ser múltiplos de R$ 5,00");
        }
        super.sacar(valor);
    }


    }