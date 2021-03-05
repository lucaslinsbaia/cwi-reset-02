package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretoresRepository {

    static List<DiretorEntity> diretores = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<DiretorEntity> getDiretor(){
        return diretores;
    }

    public Long criarDiretor(final DiretorEntity diretorSalvar) {
        if(diretorSalvar.getId() == null){
            diretorSalvar.setId(contadorIds);
            contadorIds++;
        }

        diretores.add(diretorSalvar);

        return diretorSalvar.getId();
    }

    public DiretorEntity acharDiretorPorId(final Long id) {

        for(DiretorEntity diretorEntity : diretores){
            if(diretorEntity.getId().equals(id)){
                return diretorEntity;
            }
        }

        throw new NotFoundException("Não encontrei diretores para este filme");
    }
}
