package br.unitins.greentech.repository;

import br.unitins.greentech.model.Prevencao;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrevencaoRepository implements PanacheRepository<Prevencao> {
    
    public PanacheQuery<Prevencao> findByNome(String nome, Sort sort){

        if (nome == null)
            return null;

        return find("UPPER(nome) LIKE ?1 ", sort, "%"+nome.toUpperCase()+"%");
    }
}
