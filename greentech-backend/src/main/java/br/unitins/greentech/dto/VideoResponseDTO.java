package br.unitins.greentech.dto;

import br.unitins.greentech.model.Video;

public record VideoResponseDTO (
    Long id,
    String nome,
    String urlVideo,
    String descricao
) {
    public static VideoResponseDTO valueOf(Video video) {
            return new VideoResponseDTO(
                    video.getId(),
                    video.getNome(),
                    video.getUrlVideo(),
                    video.getDescricao());
        }
    
}
