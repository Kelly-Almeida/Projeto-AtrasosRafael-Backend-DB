package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.Ambiente;
import org.triomaravilha.atrasosrafael.dominio.repositories.AmbienteRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;


import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class JpaAmbienteRepository implements AmbienteRepository {
    private final AmbienteEntityRepository ambienteRepository;

    public JpaAmbienteRepository(AmbienteEntityRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public AmbienteEntity save(AmbienteEntity ambiente) {

        return ambienteRepository.save(ambiente);
    }


    @Override
    public Ambiente findById(Long id) {
        return ambienteRepository.findById(id).stream().map(JpaAmbienteRepository::mapper).findFirst().orElse(null);
    }

    @Override
    public List<Ambiente> findAll() {
        Iterable<AmbienteEntity> ambienteEntities = ambienteRepository.findAll();

        return StreamSupport.stream(ambienteEntities.spliterator(), false)
                .map(JpaAmbienteRepository::mapper).toList();
    }

    @Override
    public void deleteId(Long id) {
        ambienteRepository.deleteById(id);
    }

    public static Ambiente mapper(AmbienteEntity ambienteEntity) {
        if (ambienteEntity == null) return null;

        Ambiente ambiente = new Ambiente();
        ambiente.setId(ambienteEntity.getId());
        ambiente.setTemperatura(ambienteEntity.getTemperatura());
        ambiente.setUmidade(ambienteEntity.getUmidade());
        ambiente.setObservacoes(ambienteEntity.getObservacoes());

        return ambiente;
    }

    public static AmbienteEntity mapper(Ambiente ambiente) {
        if (ambiente == null) return null;

        AmbienteEntity ambienteEntity = new AmbienteEntity();
        ambienteEntity.setId(ambiente.getId());
        ambienteEntity.setTemperatura(ambiente.getTemperatura());
        ambienteEntity.setUmidade(ambiente.getUmidade());
        ambienteEntity.setObservacoes(ambiente.getObservacoes());

        return ambienteEntity;
    }
}
