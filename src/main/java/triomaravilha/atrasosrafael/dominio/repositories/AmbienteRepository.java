package triomaravilha.atrasosrafael.dominio.repositories;

import triomaravilha.atrasosrafael.dominio.Ambiente;
import triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;

import java.util.List;

public interface AmbienteRepository {
    AmbienteEntity save(AmbienteEntity ambiente);
    Ambiente findById(Long id);
    List<Ambiente> findAll();
    void deleteId(Long id);
}
