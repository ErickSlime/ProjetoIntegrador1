package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.DicaDTO;
import br.unitins.greentech.model.Dica;
import br.unitins.greentech.repository.DicaRepository;
import br.unitins.greentech.repository.PlantaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class DicaImplService implements DicaService {

    @Inject
    DicaRepository dicaRepository;

    @Inject
    PlantaRepository plantaRepository;

    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Dica> getAll() {
        
        return dicaRepository.findAll(sort).list();
    }

    @Override
    public Dica getById(Long id) {
        
        Dica dica = dicaRepository.findById(id);

        if (dica == null)
            throw new NotFoundException("Não encontrado");

        return dica;
    }

    @Override
    @Transactional
    public Dica insert(DicaDTO dicaDTO) {
        
        Dica dica = new Dica();

        dica.setNome(dicaDTO.nome());

        dica.setNomeImagem(dicaDTO.nomeImagem());

        dica.setDescricao(dicaDTO.descricao());

        dica.setPlanta(plantaRepository.findById(dicaDTO.planta()));

        dicaRepository.persist(dica);

        return dica;
    }

    @Override
    @Transactional
    public Dica update(Long id, DicaDTO dicaDTO) {
        
        Dica dica = dicaRepository.findById(id);

        if (dica == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        dica.setNome(dicaDTO.nome());

        dica.setNomeImagem(dicaDTO.nomeImagem());

        dica.setDescricao(dicaDTO.descricao());

        dica.setPlanta(plantaRepository.findById(dicaDTO.planta()));

        return dica;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Dica dica = dicaRepository.findById(id);

        if (dicaRepository.isPersistent(dica))
            dicaRepository.delete(dica);

        else
            throw new NotFoundException("Nenhuma dica encontrado");
    }

    @Override
    public Long count() {
        
        return dicaRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return dicaRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Dica> getByNome(String nome) {
        
        return dicaRepository.findByNome(nome, sort).list();
    }
}
