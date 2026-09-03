package org.triomaravilha.atrasosrafael.infrastructure.mapper;

import org.triomaravilha.atrasosrafael.dominio.model.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AtrasosEntity;
import org.triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;

public interface MapperAtrasos {
     static Atrasos mapper(AtrasosEntity entity) {
        if (entity == null) return null;

        Atrasos atraso = new Atrasos();
        atraso.setCode(entity.getCode());
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

     static AtrasosEntity mapper(Atrasos atraso) {
        if (atraso == null) return null;

        AtrasosEntity entity = new AtrasosEntity();
        entity.setCode(atraso.getCode());
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
