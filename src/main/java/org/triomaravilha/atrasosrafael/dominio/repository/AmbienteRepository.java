package org.triomaravilha.atrasosrafael.dominio.repository;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import java.util.List;

public interface AmbienteRepository {
    AmbienteResponseDTO save(AmbienteRequestDTO ambiente);
    AmbienteResponseDTO findById(Long id);
    List<AmbienteResponseDTO> findAll();
    void deleteId(Long id);
}
