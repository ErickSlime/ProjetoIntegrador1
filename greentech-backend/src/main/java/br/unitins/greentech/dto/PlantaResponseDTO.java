package br.unitins.greentech.dto;

import br.unitins.greentech.model.Planta;

public record PlantaResponseDTO(
        Long id,
        String nome,
        String nomeImagem,
        String descricao,
        TipoSoloResponseDTO tipoSolo,
        EspecieResponseDTO especie) {

    public static PlantaResponseDTO valueOf(Planta planta) {
        return new PlantaResponseDTO(
                planta.getId(),
                planta.getNome(),
                planta.getNomeImagem(),
                planta.getDescricao(),
                TipoSoloResponseDTO.valueOf(planta.getTipoSolo()),
                EspecieResponseDTO.valueOf(planta.getEspecie()));
    }

}
