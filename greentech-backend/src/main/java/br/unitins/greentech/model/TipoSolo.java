package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class TipoSolo extends DefaultEntity {
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
