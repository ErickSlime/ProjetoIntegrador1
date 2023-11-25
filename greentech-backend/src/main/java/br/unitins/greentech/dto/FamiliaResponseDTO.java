package br.unitins.greentech.dto;

import br.unitins.greentech.model.Familia;

public record FamiliaResponseDTO (
    Long id,
    String nome,
    String caracteristicas
) {
    
    public static FamiliaResponseDTO valueOf(Familia familia) {
        return new FamiliaResponseDTO(
            familia.getId(), 
            familia.getNome(),
            familia.getCaracteristicas()
        );
    }

}
