package br.unitins.greentech.repository;

import br.unitins.greentech.model.Familia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FamiliaRepository implements PanacheRepository<Familia> {
    
}
