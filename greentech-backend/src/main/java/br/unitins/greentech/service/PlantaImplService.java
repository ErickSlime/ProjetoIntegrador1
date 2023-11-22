package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.PlantaDTO;
import br.unitins.greentech.model.Planta;
import br.unitins.greentech.repository.EspecieRepository;
import br.unitins.greentech.repository.PlantaRepository;
import br.unitins.greentech.repository.PragaRepository;
import br.unitins.greentech.repository.TipoSoloRepository;
import br.unitins.greentech.repository.VideoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

public class PlantaImplService implements PlantaService {
    
    @Inject
    PlantaRepository plantaRepository;
    
    @Inject
    TipoSoloRepository tipoSoloRepository;
    
    @Inject
    EspecieRepository especieRepository;
    
    @Inject
    VideoRepository videoRepository;
    
    @Inject
    PragaRepository pragaRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Planta> getAll() {
        
        return plantaRepository.findAll(sort).list();
    }

    @Override
    public List<Planta> getAll(int page, int pageSize) {
        
        return plantaRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Planta getById(Long id) {
        
        Planta planta = plantaRepository.findById(id);

        if (planta == null)
            throw new NotFoundException("Não encontrado");

        return planta;
    }

    @Override
    @Transactional
    public Planta insert(PlantaDTO plantaDTO) {
        
        Planta planta = new Planta();

        planta.setNome(plantaDTO.nome());

        planta.setNomeImagem(plantaDTO.nomeImagem());

        planta.setTempoColheita(plantaDTO.tempoColheita());

        planta.setDescricao(plantaDTO.descricao());

        planta.setTipoSolo(tipoSoloRepository.findById(plantaDTO.tipoSolo()));

        planta.setEspecie(especieRepository.findById(plantaDTO.especie()));

        for (Long video : plantaDTO.videos()) {
            
            planta.plusVideos(videoRepository.findById(video));
        }

        for (Long praga : plantaDTO.pragas()) {
            
            planta.plusPragas(pragaRepository.findById(praga));
        }

        plantaRepository.persist(planta);

        return planta;
    }

    @Override
    @Transactional
    public Planta update(Long id, PlantaDTO plantaDTO) {

        int tamanhoArray;
        
        Planta planta = plantaRepository.findById(id);

        if (planta == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        planta.setNome(plantaDTO.nome());

        planta.setNomeImagem(plantaDTO.nomeImagem());

        planta.setTempoColheita(plantaDTO.tempoColheita());

        planta.setDescricao(plantaDTO.descricao());

        planta.setTipoSolo(tipoSoloRepository.findById(plantaDTO.tipoSolo()));

        planta.setEspecie(especieRepository.findById(plantaDTO.especie()));

        tamanhoArray = planta.getVideos().size();

        while (tamanhoArray != 0) {
            
            planta.getVideos().remove(0);

            tamanhoArray--;
        }

        for (Long genero : plantaDTO.videos()) {
            
            planta.plusVideos(videoRepository.findById(genero));
        }

        tamanhoArray = planta.getPragas().size();

        while (tamanhoArray != 0) {
            
            planta.getPragas().remove(0);

            tamanhoArray--;
        }

        for (Long praga : plantaDTO.pragas()) {
            
            planta.plusPragas(pragaRepository.findById(praga));
        }

        return planta;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Planta planta = plantaRepository.findById(id);

        if (plantaRepository.isPersistent(planta))
            plantaRepository.delete(planta);

        else
            throw new NotFoundException("Nenhuma planta encontrado");
    }

    @Override
    public Long count() {
        
        return plantaRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return plantaRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Planta> getByNome(String nome, int page, int pageSize) {
        
        return plantaRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
