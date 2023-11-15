package br.unitins.greentech.dto;

import java.time.LocalDate;
import java.util.List;

public record PlantaDTO (
    String nome,
    String nomeImagem,
    LocalDate tempoColheita,
    String descricao,
    Long tipoSolo,
    Long especie,
    List<Long> videos,
    List<Long> pragas
) {
    
}
