package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class Especie extends DefaultEntity {
    
    private String nome;
    private String caracteristicas;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCaracteristicas() {
        return caracteristicas;
    }
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

}
