package org.triomaravilha.atrasosrafael.dominio.repository;

import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.model.Atrasos;
import java.util.List;

public interface AtrasosRepository {
    AtrasosResponseDTO save(AtrasosRequestDTO atrasos);
    List<AtrasosResponseDTO> findAll();
    AtrasosResponseDTO findById(Long id);
    AtrasosResponseDTO update(AtrasosRequestDTO atrasos, Long id);
    void deleteById(Long id);
}
