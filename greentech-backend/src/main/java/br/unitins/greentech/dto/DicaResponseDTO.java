package br.unitins.greentech.dto;

import br.unitins.greentech.model.Planta;

public record DicaResponseDTO (
    Long id,
    String nomeImagem,
    String descricao,
    Planta planta
) {
    
}
