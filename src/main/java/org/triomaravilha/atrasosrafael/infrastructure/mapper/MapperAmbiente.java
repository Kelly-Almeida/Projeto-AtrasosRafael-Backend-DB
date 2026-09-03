package org.triomaravilha.atrasosrafael.infrastructure.mapper;

import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AmbienteEntity;

public interface MapperAmbiente {

    static Ambiente mapper(AmbienteEntity ambienteEntity) {
        if (ambienteEntity == null) return null;

        Ambiente ambiente = new Ambiente();
        ambiente.setId(ambienteEntity.getId());
        ambiente.setTemperatura(ambienteEntity.getTemperatura());
        ambiente.setUmidade(ambienteEntity.getUmidade());

        return ambiente;
    }

    static AmbienteEntity mapper(Ambiente ambiente) {
        if (ambiente == null) return null;

        AmbienteEntity ambienteEntity = new AmbienteEntity();
        ambienteEntity.setId(ambiente.getId());
        ambienteEntity.setTemperatura(ambiente.getTemperatura());
        ambienteEntity.setUmidade(ambiente.getUmidade());

        return ambienteEntity;
    }
}
