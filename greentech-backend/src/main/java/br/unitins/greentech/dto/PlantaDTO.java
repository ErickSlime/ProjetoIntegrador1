package br.unitins.greentech.dto;

import java.time.LocalDate;
import java.util.List;

public record PlantaDTO (
    String nome,
    String nomeImagem,
    String descricao,
    Long tipoSolo,
    EspecieDTO especie
) {
    
}
