package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PrevencaoDTO;
import br.unitins.greentech.model.Prevencao;
import br.unitins.greentech.repository.PrevencaoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PrevencaoImplService implements PrevencaoService {

    @Inject
    PrevencaoRepository prevencaoRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Prevencao> getAll() {
        
        return prevencaoRepository.findAll(sort).list();
    }

    @Override
    public List<Prevencao> getAll(int page, int pageSize) {
        
        return prevencaoRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Prevencao getById(Long id) {
        
        Prevencao prevencao = prevencaoRepository.findById(id);

        if (prevencao == null)
            throw new NotFoundException("Não encontrado");

        return prevencao;
    }

    @Override
    @Transactional
    public Prevencao insert(PrevencaoDTO prevencaoDTO) {
        
        Prevencao prevencao = new Prevencao();

        prevencao.setNome(prevencaoDTO.nome());

        prevencao.setComoPrevenir(prevencaoDTO.comoPrevenir());

        prevencaoRepository.persist(prevencao);

        return prevencao;
    }

    @Override
    @Transactional
    public Prevencao update(Long id, PrevencaoDTO prevencaoDTO) {
        
        Prevencao prevencao = prevencaoRepository.findById(id);

        if (prevencao == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        prevencao.setNome(prevencaoDTO.nome());

        prevencao.setComoPrevenir(prevencaoDTO.comoPrevenir());

        return prevencao;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Prevencao prevencao = prevencaoRepository.findById(id);

        if (prevencaoRepository.isPersistent(prevencao))
            prevencaoRepository.delete(prevencao);

        else
            throw new NotFoundException("Nenhuma prevencao encontrado");
    }

    @Override
    public Long count() {
        
        return prevencaoRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return prevencaoRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Prevencao> getByNome(String nome, int page, int pageSize) {
        
        return prevencaoRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
