package br.unitins.greentech.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Praga extends DefaultEntity {

    private String nome;
    private String nomeImagem;
    private String descricao;

    @OneToMany
    @JoinColumn(name = "id_prevencoes", nullable = true)
    private List<Prevencao> prevencoes;

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

    public List<Prevencao> getPrevencoes() {
        return prevencoes;
    }

    public void setPrevencoes(List<Prevencao> prevencoes) {
        this.prevencoes = prevencoes;
    }

    public void plusPrevencoes(Prevencao prevencao) {

        if (prevencoes == null) {

            prevencoes = new ArrayList<>();
        }

        this.prevencoes.add(prevencao);
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
