package br.unitins.greentech.service;

import java.util.List;

import br.unitins.greentech.dto.VideoDTO;
import br.unitins.greentech.model.Video;

public interface VideoService {
    
    List<Video> getAll();
    
    Video getById(Long id);

    Video insert(VideoDTO videoDTO);

    Video update(Long id, VideoDTO videoDTO);

    void delete(Long id);

    Long count();

    Long countByNome(String nome);

    List<Video> getByNome(String nome);
}
