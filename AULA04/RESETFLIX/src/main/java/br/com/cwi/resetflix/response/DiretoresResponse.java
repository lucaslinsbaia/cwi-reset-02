package br.com.cwi.resetflix.response;

public class DiretoresResponse {
    Long id;
    String nome;

    public DiretoresResponse(final Long id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public DiretoresResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }


}
