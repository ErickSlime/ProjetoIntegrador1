package br.unitins.greentech.repository;

import br.unitins.greentech.model.TipoSolo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoSoloRepository implements PanacheRepository<TipoSolo> {
    
}