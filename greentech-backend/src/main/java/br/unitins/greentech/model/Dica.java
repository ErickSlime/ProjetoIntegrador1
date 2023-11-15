package br.unitins.greentech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dica extends DefaultEntity {
    
    private String nome;
    private String nomeImagem;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_planta", nullable = false)
    private Planta planta;
    
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
    public Planta getPlanta() {
        return planta;
    }
    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
