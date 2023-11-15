package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class Prevencao extends DefaultEntity {
    
    private String nome;
    private String comoPrevenir;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getComoPrevenir() {
        return comoPrevenir;
    }
    public void setComoPrevenir(String comoPrevenir) {
        this.comoPrevenir = comoPrevenir;
    }
}
