package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.FilmesResponse;

public class FilmeEntityMapper {

    public FilmeEntity mapear(final CriarFilmeRequest request, final FilmesResponse response) {
        return new FilmeEntity(response.getId(), request.getNome(), request.getGenero(), request.getIdDiretor(), request.getIdsAtores());
    }

}
