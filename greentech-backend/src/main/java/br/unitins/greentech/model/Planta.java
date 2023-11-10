package br.unitins.greentech.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Planta extends DefaultEntity {
    
    private String nome;
    private String nomeImagem;
    private String especie;
    private LocalDate tempoColheita;
    private String descricao;

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
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public LocalDate getTempoColheita() {
        return tempoColheita;
    }
    public void setTempoColheita(LocalDate tempoColheita) {
        this.tempoColheita = tempoColheita;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
