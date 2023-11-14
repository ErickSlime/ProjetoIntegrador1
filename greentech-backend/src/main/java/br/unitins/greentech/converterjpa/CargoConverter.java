package br.unitins.greentech.converterjpa;

import br.unitins.greentech.model.Cargo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CargoConverter implements AttributeConverter<Cargo, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Cargo cargo) {

        return cargo == null ? null : cargo.getId();
    }

    @Override
    public Cargo convertToEntityAttribute(Integer id) {

        return Cargo.valueOf(id);
    }
}
