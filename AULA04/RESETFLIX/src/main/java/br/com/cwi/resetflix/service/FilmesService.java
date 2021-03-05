package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmesResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;

import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;
    private DiretoresRepository diretoresRepository;
    private AtoresRepository atoresRepository;


    static FilmesResponseMapper MAPPER_RESPONSE = new FilmesResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();


    public List<FilmesResponse> getFilmes() {
        final List<FilmeEntity> filmes = filmesRepository.getFilmes();
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long criarFilme(final CriarFilmeRequest request) {
        //TODO Implementar a lógica de criar o filme
//        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
//         filmesRepository.criarFilme(filmeSalvar);
//        return filmeSalvar.getId();
        return null;
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(final Long id) {
        FilmeEntity filmeSalvo = filmesRepository.acharFilmePorId(id);
        List<AtorEntity> atoresFilme = atoresRepository.getAtores();
        List<DiretorEntity> diretorFilme = diretoresRepository.getDiretor();
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretorFilme, atoresFilme);
    }
}
