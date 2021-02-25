package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.TiposDeContaBancaria;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        //INSTITUIÇÕES BANCÁRIAS
        /* Estou com problemas para passar a instituição formatada
        * para a String final. Não esquecer de ajustar este comportamento!!! */

        String bradesco = InstituicaoBancaria.BRADESCO.getInstituicaoBancaria();
        String nubank = InstituicaoBancaria.NUBANK.getInstituicaoBancaria();
        String bancoDoBrasil = InstituicaoBancaria.BANCO_DO_BRASIL.getInstituicaoBancaria();
        String itau = InstituicaoBancaria.ITAU.getInstituicaoBancaria();
        String caixa = InstituicaoBancaria.CAIXA.getInstituicaoBancaria();

        //INSTANCIANDO AS CONTAS
        ContaBancaria c1 = new ContaDigital(TiposDeContaBancaria.CONTA_DIGITAL, InstituicaoBancaria.BANCO_DO_BRASIL, 3352,1520.50);
        ContaBancaria c2 = new ContaCorrente(TiposDeContaBancaria.CONTA_CORRENTE, InstituicaoBancaria.CAIXA, 1028,2820.00);
        ContaBancaria c3 = new ContaCorrente(TiposDeContaBancaria.CONTA_CORRENTE, InstituicaoBancaria.CAIXA, 2832,15020.00);

//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c1.consultarSaldo()));
//        c1.sacar(1200.00);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c1.consultarSaldo()));
//        c1.transferir(1000.0, c2);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c1.consultarSaldo()));
//        c1.depositar(550.0);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c1.consultarSaldo()));
//        c1.transferir(850.0, c3);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c1.consultarSaldo()));


        //TESTANDO APLICAÇÃO DE REGRAS DE NEGÓCIO
        System.out.println("------------------------------------");
        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
        c2.sacar(1200.00);
        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
        c2.transferir(250.0, c3);
        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
        System.out.println("------------------------------------");


    }
}
