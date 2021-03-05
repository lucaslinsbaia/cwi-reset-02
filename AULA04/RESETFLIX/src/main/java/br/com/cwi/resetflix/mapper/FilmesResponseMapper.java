package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.FilmesResponse;

import static java.util.Objects.isNull;

public class FilmesResponseMapper {

    public FilmesResponse mapear(final FilmeEntity filmeEntity) {
        if(isNull(filmeEntity)) {
            return null;
        }

        return new FilmesResponse(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getGenero());
        }
}
