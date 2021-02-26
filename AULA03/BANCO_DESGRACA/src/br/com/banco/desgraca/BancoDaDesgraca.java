package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.conta.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {


        //INSTANCIANDO AS CONTAS
        ContaBancaria c1 = new ContaDigital(TiposDeContaBancaria.CONTA_DIGITAL, InstituicaoBancaria.NUBANK, 3352,1520.50);
        ContaBancaria c2 = new ContaCorrente(TiposDeContaBancaria.CONTA_CORRENTE, InstituicaoBancaria.CAIXA, 1028,2820.00);
        ContaBancaria c3 = new ContaPoupanca(TiposDeContaBancaria.CONTA_POUPANCA, InstituicaoBancaria.CAIXA, 2832,1020.00);

        c1.depositar(50.0);
        System.out.println();
        c1.sacar(200.0);
        System.out.println();
        c1.transferir(200.0, c3);
        System.out.println();
        c1.depositar(1500.0);
        System.out.println();
        c3.transferir(250.0, c2);
        System.out.println();
        System.out.println();
        System.out.println();
        c1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2021, 7, 1));





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
//        System.out.println("------------------------------------");
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
//        c2.sacar(1200.00);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
//        c2.transferir(250.0, c3);
//        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(c2.consultarSaldo()));
//        System.out.println("------------------------------------");




    }
}
