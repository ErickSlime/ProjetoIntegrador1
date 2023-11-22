package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PrevencaoDTO;
import br.unitins.greentech.model.Prevencao;

public interface PrevencaoService {
    
    List<Prevencao> getAll();
    
    List<Prevencao> getAll(int page, int pageSize);
    
    Prevencao getById(Long id);

    Prevencao insert(PrevencaoDTO prevencaoDTO);

    Prevencao update(Long id, PrevencaoDTO prevencaoDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Prevencao> getByNome(String nome, int page, int pageSize);
}
