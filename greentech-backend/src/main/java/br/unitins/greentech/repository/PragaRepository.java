package br.unitins.greentech.repository;

import br.unitins.greentech.model.Praga;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PragaRepository implements PanacheRepository<Praga> {
    
}
