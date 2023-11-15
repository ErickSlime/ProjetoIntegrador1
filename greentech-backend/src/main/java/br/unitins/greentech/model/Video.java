package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class Video extends DefaultEntity {
    
    private String nome;
    private String urlVideo;
    private String descricao;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUrlVideo() {
        return urlVideo;
    }
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
