package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PragaDTO;
import br.unitins.greentech.model.Praga;
import br.unitins.greentech.repository.EspecieRepository;
import br.unitins.greentech.repository.PragaRepository;
import br.unitins.greentech.repository.PrevencaoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PragaImplService implements PragaService {

    @Inject
    PragaRepository pragaRepository;
    
    @Inject
    PrevencaoRepository prevencaoRepository;

    @Inject
    EspecieRepository especieRepository;

    @Inject
    EspecieService especieService;

    @Inject
    PrevencaoService prevencaoService;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Praga> getAll() {
        
        return pragaRepository.findAll(sort).list();
    }

    @Override
    public List<Praga> getAll(int page, int pageSize) {
        
        return pragaRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Praga getById(Long id) {
        
        Praga praga = pragaRepository.findById(id);

        if (praga == null)
            throw new NotFoundException("Não encontrado");

        return praga;
    }

    @Override
    @Transactional
    public Praga insert(PragaDTO pragaDTO) {
        
        Praga praga = new Praga();

        praga.setNome(pragaDTO.nome());

        praga.setNomeImagem(pragaDTO.nomeImagem());

        praga.setDescricao(pragaDTO.descricao());

        praga.setEspecie(especieService.insert(pragaDTO.especie()));

        pragaRepository.persist(praga);

        return praga;
    }

    @Override
    @Transactional
    public Praga update(Long id, PragaDTO pragaDTO) {
        
        
        Praga praga = pragaRepository.findById(id);

        if (praga == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        praga.setNome(pragaDTO.nome());

        praga.setNomeImagem(pragaDTO.nomeImagem());

        praga.setDescricao(pragaDTO.descricao());

        praga.setEspecie(especieService.insert(pragaDTO.especie()));

        return praga;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Praga praga = pragaRepository.findById(id);

        if (pragaRepository.isPersistent(praga))
            pragaRepository.delete(praga);

        else
            throw new NotFoundException("Nenhuma praga encontrado");
    }

    @Override
    public Long count() {
        
        return pragaRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return pragaRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Praga> getByNome(String nome, int page, int pageSize) {
        
        return pragaRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
