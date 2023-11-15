package br.unitins.greentech.repository;

import br.unitins.greentech.model.TipoSolo;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoSoloRepository implements PanacheRepository<TipoSolo> {
    
    public PanacheQuery<TipoSolo> findByNome(String nome, Sort sort){

        if (nome == null)
            return null;

        return find("UPPER(nome) LIKE ?1 ", sort, "%"+nome.toUpperCase()+"%");
    }
}
