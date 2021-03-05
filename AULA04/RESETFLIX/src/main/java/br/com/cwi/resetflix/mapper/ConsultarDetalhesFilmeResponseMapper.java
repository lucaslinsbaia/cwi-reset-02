package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.*;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filmeSalvo, final List<DiretorEntity> diretor, final List<AtorEntity> atores) {
        List<DiretoresResponse> diretorFilme = new DiretoresResponseMapper().mapear(diretor);
        List<AtoresResponse> atoresDoFilme = new AtoresResponseMapper().mapear(atores);
        return new ConsultarDetalhesFilmeResponse(filmeSalvo.getId(),
                filmeSalvo.getNome(), filmeSalvo.getGenero(), (DiretoresResponse) diretorFilme, atoresDoFilme);
    }
}



