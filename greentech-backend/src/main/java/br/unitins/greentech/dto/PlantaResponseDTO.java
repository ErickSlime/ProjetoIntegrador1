package br.unitins.greentech.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.unitins.greentech.model.Planta;
import br.unitins.greentech.model.Praga;

public record PlantaResponseDTO(
        Long id,
        String nome,
        String nomeImagem,
        String descricao,
        TipoSoloResponseDTO tipoSolo,
        EspecieResponseDTO especie,
        List<Praga> pragas) {

    public static PlantaResponseDTO valueOf(Planta planta) {
        return new PlantaResponseDTO(
                planta.getId(),
                planta.getNome(),
                planta.getNomeImagem(),
                planta.getDescricao(),
                TipoSoloResponseDTO.valueOf(planta.getTipoSolo()),
                EspecieResponseDTO.valueOf(planta.getEspecie()),
                planta.getPragas());
    }

}
