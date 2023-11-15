package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class TipoSolo extends DefaultEntity {
    
    private String nome;

    private Classificacao classificacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
}
