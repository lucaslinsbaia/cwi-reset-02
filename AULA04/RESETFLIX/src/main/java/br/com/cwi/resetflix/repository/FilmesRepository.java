package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmesRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long contadorIds = 1l;


    public List<FilmeEntity> getFilmes(){
        return filmes;
    }


    public Long criarFilme(final FilmeEntity filmeSalvar) {
        if(filmeSalvar.getId() == null){
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }

        filmes.add(filmeSalvar);

        return filmeSalvar.getId();
    }

    public List<FilmeEntity> acharFilmesAtor(final Long idAtor) {
        for(FilmeEntity filmeEntity: filmes) {
            if(filmeEntity.getIdsAtores().equals(idAtor)) {
                return getFilmes();

            } else {
                throw new NotFoundException("Ator não encontrado em nenhum filme");
            }
        } return null;
    }

    public List<FilmeEntity> acharFilmesDiretor(final Long idDiretor) {
        for(FilmeEntity filmeEntity: filmes) {
            if(filmeEntity.getIdDiretor().equals(idDiretor)) {
                return getFilmes();

            } else {
                throw new NotFoundException("Diretor não encontrado em nenhum filme");
            }
        } return null;
    }

    public FilmeEntity acharFilmePorId(final Long id) {
        for(FilmeEntity filmeEntity : filmes){
            if(filmeEntity.getId().equals(id)){
            //TODO Implementar retorno do método de achar filme por id;
                //                return filmeEntity;
            }

        }  throw new NotFoundException("Não encontrei nenhum filme com este Id");

    }

}



