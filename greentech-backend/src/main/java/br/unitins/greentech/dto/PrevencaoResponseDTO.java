package br.unitins.greentech.dto;

import br.unitins.greentech.model.Prevencao;

public record PrevencaoResponseDTO (
    Long id,
    String nome,
    String comoPrevenir
) {

    public static PrevencaoResponseDTO valueOf(Prevencao prevencao) {
            return new PrevencaoResponseDTO(
                    prevencao.getId(),
                    prevencao.getNome(),
                    prevencao.getComoPrevenir());
        }
    
}
