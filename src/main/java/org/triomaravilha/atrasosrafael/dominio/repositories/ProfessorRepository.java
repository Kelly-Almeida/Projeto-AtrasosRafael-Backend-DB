package org.triomaravilha.atrasosrafael.dominio.repositories;


import org.triomaravilha.atrasosrafael.dominio.Professor;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.ProfessorEntity;

import java.util.List;

public interface ProfessorRepository {
    ProfessorEntity save(Professor professor);
    List<Professor> findAll();
    Professor findByID(Long id);
    ProfessorEntity update(Professor professor, Long id);
    void delete(Long id);
}
