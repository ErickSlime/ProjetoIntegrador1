package br.unitins.greentech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Praga extends DefaultEntity {
    
    private String nome;
    private String nomeImagem;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_especie", nullable = false)
    private Especie especie;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomeImagem() {
        return nomeImagem;
    }
    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
