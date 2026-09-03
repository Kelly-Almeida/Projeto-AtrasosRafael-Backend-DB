package org.triomaravilha.atrasosrafael.infrastructure.mapper;

import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import org.triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;

public interface MapperProfessor {

    static ProfessorEntity mapper(Professor professor) {
        ProfessorEntity professorEntity = new ProfessorEntity();

        professorEntity.setId(professor.getId());
        professorEntity.setNome(professor.getNome());
        professorEntity.setFoto(professor.getFoto());

        return professorEntity;
    }

    static Professor mapper(ProfessorEntity professorEntity) {
        Professor professor = new Professor();

        professor.setId(professorEntity.getId());
        professor.setNome(professorEntity.getNome());
        professor.setFoto(professorEntity.getFoto());

        return professor;
    }
}
