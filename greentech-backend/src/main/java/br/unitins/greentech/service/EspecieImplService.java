package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.EspecieDTO;
import br.unitins.greentech.model.Especie;
import br.unitins.greentech.repository.EspecieRepository;
import br.unitins.greentech.repository.FamiliaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EspecieImplService implements EspecieService {

    @Inject
    EspecieRepository especieRepository;
    
    @Inject
    FamiliaRepository familiaRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Especie> getAll() {
        
        return especieRepository.findAll(sort).list();
    }

    @Override
    public List<Especie> getAll(int page, int pageSize) {
        
        return especieRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Especie getById(Long id) {
        
        Especie especie = especieRepository.findById(id);

        if (especie == null)
            throw new NotFoundException("Não encontrado");

        return especie;
    }

    @Override
    @Transactional
    public Especie insert(EspecieDTO especieDTO) {
        
        Especie especie = new Especie();

        especie.setNome(especieDTO.nome());

        especie.setCaracteristicas(especieDTO.caracteristicas());

        especie.setFamilia(familiaRepository.findById(especieDTO.familia()));

        especieRepository.persist(especie);

        return especie;
    }

    @Override
    @Transactional
    public Especie update(Long id, EspecieDTO especieDTO) {
        
        Especie especie = especieRepository.findById(id);

        if (especie == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        especie.setNome(especieDTO.nome());

        especie.setCaracteristicas(especieDTO.caracteristicas());

        especie.setFamilia(familiaRepository.findById(especieDTO.familia()));

        return especie;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Especie especie = especieRepository.findById(id);

        if (especieRepository.isPersistent(especie))
            especieRepository.delete(especie);

        else
            throw new NotFoundException("Nenhuma especie encontrado");
    }

    @Override
    public Long count() {
        
        return especieRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return especieRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Especie> getByNome(String nome, int page, int pageSize) {
        
        return especieRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
