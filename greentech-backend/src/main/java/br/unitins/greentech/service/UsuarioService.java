package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.UsuarioDTO;
import br.unitins.greentech.model.Usuario;

public interface UsuarioService {
    
    List<Usuario> getAll();
    
    List<Usuario> getAll(int page, int pageSize);
    
    Usuario getById(Long id);

    Usuario insert(UsuarioDTO usuarioDTO);

    Usuario update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Usuario> getByNome(String nome, int page, int pageSize);
}
