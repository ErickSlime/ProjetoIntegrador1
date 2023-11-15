package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.UsuarioDTO;
import br.unitins.greentech.model.Cargo;
import br.unitins.greentech.model.Usuario;
import br.unitins.greentech.repository.PlantaRepository;
import br.unitins.greentech.repository.UsuarioRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioImplService implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PlantaRepository plantaRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Usuario> getAll() {
        
        return usuarioRepository.findAll(sort).list();
    }

    @Override
    public Usuario getById(Long id) {
        
        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null)
            throw new NotFoundException("Não encontrado");

        return usuario;
    }

    @Override
    @Transactional
    public Usuario insert(UsuarioDTO usuarioDTO) {
        
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.nome());

        usuario.setCpf(usuarioDTO.cpf());

        usuario.setIdade(usuarioDTO.idade());

        usuario.setEmail(usuarioDTO.email());
        
        usuario.setLogin(usuarioDTO.login());

        usuario.setSenha(usuarioDTO.senha());

        usuario.setCargo(Cargo.valueOf(usuarioDTO.cargo()));

        for (Long planta : usuarioDTO.plantas()) {
            
            usuario.plusPlantas(plantaRepository.findById(planta));
        }

        usuarioRepository.persist(usuario);

        return usuario;
    }

    @Override
    @Transactional
    public Usuario update(Long id, UsuarioDTO usuarioDTO) {

        int tamanhoArray;
        
        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        usuario.setNome(usuarioDTO.nome());

        usuario.setCpf(usuarioDTO.cpf());

        usuario.setIdade(usuarioDTO.idade());

        usuario.setEmail(usuarioDTO.email());
        
        usuario.setLogin(usuarioDTO.login());

        usuario.setSenha(usuarioDTO.senha());

        usuario.setCargo(Cargo.valueOf(usuarioDTO.cargo()));

        tamanhoArray = usuario.getPlantas().size();

        while (tamanhoArray != 0) {
            
            usuario.getPlantas().remove(0);

            tamanhoArray--;
        }

        for (Long planta : usuarioDTO.plantas()) {
            
            usuario.plusPlantas(plantaRepository.findById(planta));
        }

        return usuario;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Usuario usuario = usuarioRepository.findById(id);

        if (usuarioRepository.isPersistent(usuario))
            usuarioRepository.delete(usuario);

        else
            throw new NotFoundException("Nenhuma usuario encontrado");
    }

    @Override
    public Long count() {
        
        return usuarioRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return usuarioRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Usuario> getByNome(String nome) {
        
        return usuarioRepository.findByNome(nome, sort).list();
    }
}
