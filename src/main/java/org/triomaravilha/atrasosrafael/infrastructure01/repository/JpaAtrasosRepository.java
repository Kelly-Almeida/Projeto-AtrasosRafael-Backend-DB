package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.Professor;
import org.triomaravilha.atrasosrafael.dominio.repositories.AtrasosRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AtrasosEntity;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
@AllArgsConstructor
public class JpaAtrasosRepository implements AtrasosRepository {
    private final AtrasosEntityRepository atrasosEntityRepository;


    @Override
    public AtrasosEntity save(Atrasos atrasos) {
        AtrasosEntity entity = mapper(atrasos);

        return atrasosEntityRepository.save(entity);
    }

    @Override
    public List<Atrasos> findAll() {
        Iterable<AtrasosEntity> entities = atrasosEntityRepository.findAll();

        return StreamSupport.stream(entities.spliterator(), false)
                .map(JpaAtrasosRepository::mapper).toList();
    }

    @Override
    public Atrasos findById(Long id) {
        return atrasosEntityRepository.findById(id).stream().map(JpaAtrasosRepository::mapper).findFirst().orElse(null);
    }

    @Override
    public AtrasosEntity update(Atrasos atrasos, Long id) {
        Atrasos atrasoUp = findById(id);

        atrasoUp.setAula(atrasos.getAula());
        atrasoUp.setData(atrasos.getData());
        atrasoUp.setTempoAtraso(atrasos.getTempoAtraso());
        atrasoUp.setProfessor(atrasos.getProfessor());


        return atrasosEntityRepository.save(mapper(atrasoUp));
    }

    @Override
    public void delete(Atrasos atrasos) {
        atrasosEntityRepository.delete(mapper(atrasos));
    }

    private static Atrasos mapper(AtrasosEntity entity) {
        Atrasos atraso = new Atrasos();

        atraso.setAula(entity.getAula());
        atraso.setData(entity.getData());
        atraso.setTempoAtraso(entity.getTempoAtraso());
        atraso.setProfessor(mapper(entity).getProfessor());

        return atraso;
    }

    private static AtrasosEntity mapper(Atrasos atraso) {
        AtrasosEntity entity = new AtrasosEntity();

        entity.setAula(atraso.getAula());
        entity.setData(atraso.getData());
        entity.setTempoAtraso(atraso.getTempoAtraso());
        entity.setProfessor(mapper(atraso).getProfessor());

        return entity;
    }
}
