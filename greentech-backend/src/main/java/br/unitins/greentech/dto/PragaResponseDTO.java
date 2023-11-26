package br.unitins.greentech.dto;

import br.unitins.greentech.model.Praga;

public record PragaResponseDTO (
    Long id,
    String nome,
    String nomeImagem,
    String descricao,
    EspecieResponseDTO especie
) {
    public static PragaResponseDTO valueOf(Praga praga) {
            return new PragaResponseDTO(
                    praga.getId(),
                    praga.getNome(),
                    praga.getNomeImagem(),
                    praga.getDescricao(),
                    EspecieResponseDTO.valueOf(praga.getEspecie()));
    }
    
}
