package br.com.cwi.resetflix.response;

import java.util.List;

public class ConsultarDetalhesDiretorResponse {

    private Long id;
    private String nome;
    private List<FilmesResponse> filmes;

    public ConsultarDetalhesDiretorResponse(final Long id, final String nome,
                                         final List<FilmesResponse> filmes) {
        this.id = id;
        this.nome = nome;
        this.filmes = filmes;
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

    public List<FilmesResponse> getFilmes() {
        return filmes;
    }

    public void setFilmes(final List<FilmesResponse> filmes) {
        this.filmes = filmes;
    }

}
