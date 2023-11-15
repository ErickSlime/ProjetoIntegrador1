package br.unitins.greentech.dto;

import java.util.List;

public record PragaDTO (
    String nome,
    String nomeImagem,
    String descricao,
    List<Long> prevencoes,
    Long especie
) {
    
}
