package br.unitins.greentech.dto;

import br.unitins.greentech.model.Especie;

public record EspecieResponseDTO (
    Long id,
    String nome,
    String caracteristicas,
    FamiliaResponseDTO familia
) {
    
    public static EspecieResponseDTO valueOf(Especie especie) {
            return new EspecieResponseDTO(
                    especie.getId(),
                    especie.getNome(),
                    especie.getCaracteristicas(),
                    FamiliaResponseDTO.valueOf(especie.getFamilia()));
        }

}
