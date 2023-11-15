package br.unitins.greentech.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends PessoaFisica {
    
    private String login;
    private String senha;

    private Cargo cargo;

    @OneToMany
    @JoinColumn(name = "id_plantas", nullable = false)
    private List<Planta> plantas;
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public List<Planta> getPlantas() {
        return plantas;
    }
    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }
    public void plusPlantas(Planta planta) {
        
        if (plantas == null) {

            plantas = new ArrayList<>();
        }
        
        this.plantas.add(planta);
    }
}
