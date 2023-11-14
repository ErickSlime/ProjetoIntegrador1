package br.unitins.greentech.repository;

import br.unitins.greentech.model.Video;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VideoRepository implements PanacheRepository<Video> {
    
}
