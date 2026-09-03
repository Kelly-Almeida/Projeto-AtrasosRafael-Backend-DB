package org.triomaravilha.atrasosrafael.dominio.repository;


import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import java.util.List;

public interface ProfessorRepository {
    Professor save(Professor professor);
    List<Professor> findAll();
    Professor findByID(Long id);
    Professor update(Professor professor, Long id);
    void delete(Long id);
}
