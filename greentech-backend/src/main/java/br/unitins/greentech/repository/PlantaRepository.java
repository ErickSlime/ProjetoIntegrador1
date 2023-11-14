package br.unitins.greentech.repository;

import br.unitins.greentech.model.Planta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlantaRepository implements PanacheRepository<Planta> {
    
}
