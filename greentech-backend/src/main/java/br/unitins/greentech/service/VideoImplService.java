package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.VideoDTO;
import br.unitins.greentech.model.Video;
import br.unitins.greentech.repository.VideoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

public class VideoImplService implements VideoService {
    
    @Inject
    VideoRepository videoRepository;
    
    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<Video> getAll() {
        
        return videoRepository.findAll(sort).list();
    }

    @Override
    public List<Video> getAll(int page, int pageSize) {
        
        return videoRepository.findAll(sort).page(page, pageSize).list();
    }

    @Override
    public Video getById(Long id) {
        
        Video video = videoRepository.findById(id);

        if (video == null)
            throw new NotFoundException("Não encontrado");

        return video;
    }

    @Override
    @Transactional
    public Video insert(VideoDTO videoDTO) {
        
        Video video = new Video();

        video.setNome(videoDTO.nome());
        
        video.setUrlVideo(videoDTO.urlVideo());
        
        video.setDescricao(videoDTO.descricao());

        videoRepository.persist(video);

        return video;
    }

    @Override
    @Transactional
    public Video update(Long id, VideoDTO videoDTO) {
        
        Video video = videoRepository.findById(id);

        if (video == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        video.setNome(videoDTO.nome());
        
        video.setUrlVideo(videoDTO.urlVideo());
        
        video.setDescricao(videoDTO.descricao());

        return video;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Video video = videoRepository.findById(id);

        if (videoRepository.isPersistent(video))
            videoRepository.delete(video);

        else
            throw new NotFoundException("Nenhuma video encontrado");
    }

    @Override
    public Long count() {
        
        return videoRepository.count();
    }

    @Override
    public Long countByNome(String nome) {
        
        return videoRepository.findByNome(nome, sort).count();
    }

    @Override
    public List<Video> getByNome(String nome, int page, int pageSize) {
        
        return videoRepository.findByNome(nome, sort).page(page, pageSize).list();
    }
}
