package com.company.domain;

import com.company.exceptions.RuntimeDcException;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        if(this.nome.equals("DC Comics")) {
            throw new RuntimeDcException("Marvel only, bitch!");
        }
    }


    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }




}


