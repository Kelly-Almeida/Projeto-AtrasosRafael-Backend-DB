package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.Professor;
import org.triomaravilha.atrasosrafael.dominio.repositories.AtrasosRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AtrasosEntity;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.ProfessorEntity;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
@AllArgsConstructor
public class JpaAtrasosRepository implements AtrasosRepository {
    private final AtrasosEntityRepository atrasosEntityRepository;


    @Override
    public AtrasosEntity save(AtrasosEntity atrasos) {

        return atrasosEntityRepository.save(atrasos);
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
    public void deleteById(Long id) {
        atrasosEntityRepository.deleteById(id);
    }

    private static Atrasos mapper(AtrasosEntity entity) {
        if (entity == null) return null;

        Atrasos atraso = new Atrasos();
        atraso.setCode(entity.getCode());
        atraso.setAula(entity.getAula());
        atraso.setData(entity.getData());
        atraso.setTempoAtraso(entity.getTempoAtraso());

        if (entity.getProfessor() != null) {
            Professor professor = new Professor();
            professor.setId(entity.getProfessor().getId());
            professor.setNome(entity.getProfessor().getNome());
            professor.setFoto(entity.getProfessor().getFoto());
            atraso.setProfessor(professor);
        }

        return atraso;
    }

    private static AtrasosEntity mapper(Atrasos atraso) {
        if (atraso == null) return null;

        AtrasosEntity entity = new AtrasosEntity();
        entity.setCode(atraso.getCode());
        entity.setAula(atraso.getAula());
        entity.setData(atraso.getData());
        entity.setTempoAtraso(atraso.getTempoAtraso());

        if (atraso.getProfessor() != null) {
            ProfessorEntity professorEntity = new ProfessorEntity();
            professorEntity.setId(atraso.getProfessor().getId());
            professorEntity.setNome(atraso.getProfessor().getNome());
            professorEntity.setFoto(atraso.getProfessor().getFoto());
            entity.setProfessor(professorEntity);
        }

        return entity;
    }
}
