package br.unitins.greentech.dto;

public record PlantaDTO (
    String nome,
    String nomeImagem,
    String descricao,
    Long tipoSolo,
    EspecieDTO especie
) {
    
}
