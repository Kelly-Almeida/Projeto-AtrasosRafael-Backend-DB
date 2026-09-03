package org.triomaravilha.atrasosrafael.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import org.triomaravilha.atrasosrafael.dominio.repository.AmbienteRepository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AmbienteEntity;
import org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperAmbiente;


import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class AmbienteEntityRepository implements AmbienteRepository {
    private final JpaAmbienteEntityRepository ambienteRepository;


    public AmbienteEntityRepository(JpaAmbienteEntityRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public Ambiente save(Ambiente ambiente) {

        return MapperAmbiente.mapper(ambienteRepository.save(MapperAmbiente.mapper(ambiente)));
    }


    @Override
    public Ambiente findById(Long id) {
        return ambienteRepository.findById(id).stream().map(MapperAmbiente::mapper).findFirst().orElse(null);
    }

    @Override
    public List<Ambiente> findAll() {
        Iterable<AmbienteEntity> ambienteEntities = ambienteRepository.findAll();

        return StreamSupport.stream(ambienteEntities.spliterator(), false)
                .map(MapperAmbiente::mapper).toList();
    }

    @Override
    public void deleteId(Long id) {
        ambienteRepository.deleteById(id);
    }


}
