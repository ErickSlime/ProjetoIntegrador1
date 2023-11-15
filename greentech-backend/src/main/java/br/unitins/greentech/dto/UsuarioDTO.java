package br.unitins.greentech.dto;

import java.util.List;

public record UsuarioDTO (
    String nome,
    String cpf,
    Integer idade,
    String email,
    String login,
    String senha,
    Integer cargo,
    List<Long> plantas
) {
    
}
