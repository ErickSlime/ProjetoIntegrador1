package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PragaDTO;
import br.unitins.greentech.model.Praga;

public interface PragaService {
    
    List<Praga> getAll();
    
    List<Praga> getAll(int page, int pageSize);
    
    Praga getById(Long id);

    Praga insert(PragaDTO pragaDTO);

    Praga update(Long id, PragaDTO pragaDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Praga> getByNome(String nome, int page, int pageSize);
}
