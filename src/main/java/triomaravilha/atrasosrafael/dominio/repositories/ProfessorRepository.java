package triomaravilha.atrasosrafael.dominio.repositories;

import triomaravilha.atrasosrafael.dominio.Professor;
import triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;

import java.util.List;

public interface ProfessorRepository {
    ProfessorEntity save(Professor professor);
    List<Professor> findAll();
    Professor findByID(Long id);
    ProfessorEntity update(Professor professor, Long id);
    void delete(Long id);
}
