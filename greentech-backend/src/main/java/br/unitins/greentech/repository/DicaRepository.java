package br.unitins.greentech.repository;

import br.unitins.greentech.model.Dica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DicaRepository implements PanacheRepository<Dica> {
    
}
