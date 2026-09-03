package org.triomaravilha.atrasosrafael.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.model.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import org.triomaravilha.atrasosrafael.dominio.repository.AtrasosRepository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AtrasosEntity;
import org.triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;
import org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperAtrasos;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperAtrasos.mapper;

@Repository
@AllArgsConstructor
public class AtrasosEntityRepository implements AtrasosRepository {
    private final JpaAtrasosEntityRepository atrasosEntityRepository;


    @Override
    public Atrasos save(Atrasos atrasos) {

        return mapper(atrasosEntityRepository.save(mapper(atrasos)));
    }

    @Override
    public List<Atrasos> findAll() {
        Iterable<AtrasosEntity> entities = atrasosEntityRepository.findAll();

        return StreamSupport.stream(entities.spliterator(), false)
                .map(MapperAtrasos::mapper).toList();
    }

    @Override
    public Atrasos findById(Long id) {
        return atrasosEntityRepository.findById(id).stream().map(MapperAtrasos::mapper).findFirst().orElse(null);
    }

    @Override
    public Atrasos update(Atrasos atrasos, Long id) {

        Atrasos atrasoUp = findById(id);

        atrasoUp.setData(atrasos.getData());
        atrasoUp.setTempoAtraso(atrasos.getTempoAtraso());
        atrasoUp.setProfessor(atrasos.getProfessor());


        return mapper(atrasosEntityRepository.save(mapper(atrasoUp)));
    }

    @Override
    public void deleteById(Long id) {
        atrasosEntityRepository.deleteById(id);
    }


}
