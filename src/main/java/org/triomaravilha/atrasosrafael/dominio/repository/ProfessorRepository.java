package org.triomaravilha.atrasosrafael.dominio.repository;


import org.triomaravilha.atrasosrafael.application.dto.professor.ProfessorRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.professor.ProfessorResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import java.util.List;

public interface ProfessorRepository {
    ProfessorResponseDTO save(ProfessorRequestDTO professor);
    List<ProfessorResponseDTO> findAll();
    ProfessorResponseDTO findByID(Long id);
    ProfessorResponseDTO update(ProfessorRequestDTO professor, Long id);
    void delete(Long id);
}
