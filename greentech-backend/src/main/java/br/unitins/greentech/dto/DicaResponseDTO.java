package br.unitins.greentech.dto;

import br.unitins.greentech.model.Dica;

public record DicaResponseDTO (
    Long id,
    String nomeImagem,
    String descricao,
    PlantaResponseDTO planta
) {
    public static DicaResponseDTO valueOf(Dica dica) {
            return new DicaResponseDTO(
                    dica.getId(),
                    dica.getNome(),
                    dica.getDescricao(),
                    PlantaResponseDTO.valueOf(dica.getPlanta()));
        }
}
