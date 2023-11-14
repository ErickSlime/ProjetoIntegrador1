package br.unitins.greentech.converterjpa;

import br.unitins.greentech.model.Classificacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ClassificacaoConverter implements AttributeConverter<Classificacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Classificacao classificacao) {
        
        return classificacao == null ? null : classificacao.getId();
    }

    @Override
    public Classificacao convertToEntityAttribute(Integer id) {
        
        return Classificacao.valueOf(id);
    }
}
