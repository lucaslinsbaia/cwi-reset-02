package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL ("Banco do Brasil"),
    BRADESCO ("Banco Bradesco"),
    CAIXA ("Caixa Econômica Federal"),
    ITAU ("Banco Itaú"),
    NUBANK ("Nubank");


    private String instituicaoBancaria;

    InstituicaoBancaria(String instituicaoBancaria) {
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public String getInstituicaoBancaria() {
        return instituicaoBancaria;
    }
}