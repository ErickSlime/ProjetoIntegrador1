package br.unitins.greentech.model;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends DefaultEntity {
     
    private String cpf;
    private Integer idade;
    private String email;
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
