package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.TipoSoloDTO;
import br.unitins.greentech.model.Classificacao;
import br.unitins.greentech.model.TipoSolo;
import br.unitins.greentech.repository.TipoSoloRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class TipoSoloImplService implements TipoSoloService {

    @Inject
    TipoSoloRepository tipoSoloRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<TipoSolo> getAll() {
        
        return tipoSoloRepository.findAll(sort).list();
    }

    @Override
    public TipoSolo getById(Long id) {
        
        TipoSolo tipoSolo = tipoSoloRepository.findById(id);

        if (tipoSolo == null)
            throw new NotFoundException("Não encontrado");

        return tipoSolo;
    }

    @Override
    @Transactional
    public TipoSolo insert(TipoSoloDTO tipoSoloDTO) {
        
        TipoSolo tipoSolo = new TipoSolo();

        tipoSolo.setNome(tipoSoloDTO.nome());

        tipoSolo.setClassificacao(Classificacao.valueOf(tipoSoloDTO.classificacao()));

        tipoSoloRepository.persist(tipoSolo);

        return tipoSolo;
    }

    @Override
    @Transactional
    public TipoSolo update(Long id, TipoSoloDTO tipoSoloDTO) {
        
        TipoSolo tipoSolo = tipoSoloRepository.findById(id);

        if (tipoSolo == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        tipoSolo.setNome(tipoSoloDTO.nome());

        tipoSolo.setClassificacao(Classificacao.valueOf(tipoSoloDTO.classificacao()));

        return tipoSolo;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        TipoSolo tipoSolo = tipoSoloRepository.findById(id);

        if (tipoSoloRepository.isPersistent(tipoSolo))
            tipoSoloRepository.delete(tipoSolo);

        else
            throw new NotFoundException("Nenhuma tipoSolo encontrado");
    }

    @Override
    public Long count() {
        
        return tipoSoloRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return tipoSoloRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<TipoSolo> getByNome(String nome) {
        
        return tipoSoloRepository.findByNome(nome, sort).list();
    }
}
