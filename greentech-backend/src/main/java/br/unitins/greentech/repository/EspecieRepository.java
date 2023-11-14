package br.unitins.greentech.repository;

import br.unitins.greentech.model.Especie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EspecieRepository implements PanacheRepository<Especie> {
    
}
