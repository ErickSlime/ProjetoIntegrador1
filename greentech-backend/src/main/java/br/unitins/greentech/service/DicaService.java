package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.DicaDTO;
import br.unitins.greentech.model.Dica;

public interface DicaService {
    
    List<Dica> getAll();

    List<Dica> getAll(int page, int pageSize);
    
    Dica getById(Long id);

    Dica insert(DicaDTO dicaDTO);

    Dica update(Long id, DicaDTO dicaDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Dica> getByNome(String nome, int page, int pageSize);
}
