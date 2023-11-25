package br.unitins.greentech.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.greentech.dto.FamiliaDTO;
import br.unitins.greentech.dto.FamiliaResponseDTO;
import br.unitins.greentech.model.Familia;
import br.unitins.greentech.repository.FamiliaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FamiliaImplService implements FamiliaService {

    @Inject
    FamiliaRepository familiaRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<FamiliaResponseDTO> getAll() {
        
        List<Familia> list = familiaRepository.findAll().list();

        return list.stream().map(e -> FamiliaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public List<Familia> getAll(int page, int pageSize) {
        
        return familiaRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Familia getById(Long id) {
        
        Familia familia = familiaRepository.findById(id);

        if (familia == null)
            throw new NotFoundException("Não encontrado");

        return familia;
    }

    @Override
    @Transactional
    public Familia insert(FamiliaDTO familiaDTO) {
        
        Familia familia = new Familia();

        familia.setNome(familiaDTO.nome());

        familia.setCaracteristicas(familiaDTO.caracteristicas());

        familiaRepository.persist(familia);

        return familia;
    }

    @Override
    @Transactional
    public Familia update(Long id, FamiliaDTO familiaDTO) {
        
        Familia familia = familiaRepository.findById(id);

        if (familia == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        familia.setNome(familiaDTO.nome());

        familia.setCaracteristicas(familiaDTO.caracteristicas());

        return familia;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Familia familia = familiaRepository.findById(id);

        if (familiaRepository.isPersistent(familia))
            familiaRepository.delete(familia);

        else
            throw new NotFoundException("Nenhuma familia encontrado");
    }

    @Override
    public Long count() {
        
        return familiaRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return familiaRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Familia> getByNome(String nome, int page, int pageSize) {
        
        return familiaRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
