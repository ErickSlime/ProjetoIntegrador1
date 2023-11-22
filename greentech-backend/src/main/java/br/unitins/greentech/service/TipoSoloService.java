package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.TipoSoloDTO;
import br.unitins.greentech.model.TipoSolo;

public interface TipoSoloService {
    
    List<TipoSolo> getAll();
    
    List<TipoSolo> getAll(int page, int pageSize);
    
    TipoSolo getById(Long id);

    TipoSolo insert(TipoSoloDTO tipoSoloDTO);

    TipoSolo update(Long id, TipoSoloDTO tipoSoloDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<TipoSolo> getByNome(String nome, int page, int pageSize);
}
