package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.*;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretoresService {

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private FilmesRepository filmesRepository;

    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
    static ConsultarDetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.getDiretor();
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public Long criarDiretor(final CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretoresRepository.criarDiretor(diretorSalvar);
    }

    public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(final Long id) {
        DiretorEntity diretorSalvo = diretoresRepository.acharDiretorPorId(id);
        List<FilmeEntity> filmesDiretor = filmesRepository.acharFilmesDiretor(id);
        return MAPPER_DETALHES_DIRETOR.mapear(diretorSalvo, filmesDiretor);
    }


}
