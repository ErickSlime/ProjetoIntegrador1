package br.unitins.greentech.dto;

import br.unitins.greentech.model.Classificacao;
import br.unitins.greentech.model.TipoSolo;

public record TipoSoloResponseDTO (
    Long id,
    String nome,
    Classificacao classificacao
) {
    
    public static TipoSoloResponseDTO valueOf(TipoSolo tiposolo) {
        return new TipoSoloResponseDTO(
            tiposolo.getId(), 
            tiposolo.getNome(),
            tiposolo.getClassificacao()
        );
    }

}
