package br.unitins.greentech.repository;

import br.unitins.greentech.model.Prevencao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrevencaoRepository implements PanacheRepository<Prevencao> {
    
}
