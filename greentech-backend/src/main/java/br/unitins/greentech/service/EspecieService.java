package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.EspecieDTO;
import br.unitins.greentech.model.Especie;

public interface EspecieService {
    
    List<Especie> getAll();
    
    Especie getById(Long id);

    Especie insert(EspecieDTO especieDTO);

    Especie update(Long id, EspecieDTO especieDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Especie> getByNome(String nome);
}
