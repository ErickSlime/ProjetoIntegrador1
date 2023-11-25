package br.unitins.greentech.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Planta extends DefaultEntity {
    
    private String nome;
    private String nomeImagem;
    private LocalDate tempoColheita;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_solo", nullable = false)
    private TipoSolo tipoSolo;

    @OneToOne
    @JoinColumn(name = "id_especie", nullable = false)
    private Especie especie;

    @OneToMany
    @JoinColumn(name = "id_videos", nullable = true)
    private List<Video> videos;

    @ManyToMany
    @JoinTable(name = "planta_praga",
                joinColumns = @JoinColumn(name = "id_planta"),
                inverseJoinColumns = @JoinColumn(name = "id_praga"))
    private List<Praga> pragas;

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
    public TipoSolo getTipoSolo() {
        return tipoSolo;
    }
    public void setTipoSolo(TipoSolo tipoSolo) {
        this.tipoSolo = tipoSolo;
    }
    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    public List<Video> getVideos() {
        return videos;
    }
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    public void plusVideos(Video video) {
        
        if (videos == null) {

            videos = new ArrayList<>();
        }
        
        this.videos.add(video);
    }
    public List<Praga> getPragas() {
        return pragas;
    }
    public void setPragas(List<Praga> pragas) {
        this.pragas = pragas;
    }
    public void plusPragas(Praga praga) {
        
        if (pragas == null) {

            pragas = new ArrayList<>();
        }
        
        this.pragas.add(praga);
    }
}
