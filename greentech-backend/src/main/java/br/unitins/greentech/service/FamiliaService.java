package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.FamiliaDTO;
import br.unitins.greentech.model.Familia;

public interface FamiliaService {
    
    List<Familia> getAll();
    
    List<Familia> getAll(int page, int pageSize);
    
    Familia getById(Long id);

    Familia insert(FamiliaDTO familiaDTO);

    Familia update(Long id, FamiliaDTO familiaDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Familia> getByNome(String nome, int page, int pageSize);
}
