package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PlantaDTO;
import br.unitins.greentech.dto.PlantaResponseDTO;
import br.unitins.greentech.model.Planta;

public interface PlantaService {
    
    List<PlantaResponseDTO> getAll();
    
    List<Planta> getAll(int page, int pageSize);
    
    Planta getById(Long id);

    Planta insert(PlantaDTO plantaDTO);

    Planta update(Long id, PlantaDTO plantaDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Planta> getByNome(String nome, int page, int pageSize);
}
