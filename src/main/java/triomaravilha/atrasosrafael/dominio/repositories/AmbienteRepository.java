package triomaravilha.atrasosrafael.dominio.repositories;

import triomaravilha.atrasosrafael.dominio.Ambiente;
import triomaravilha.atrasosrafael.infra.entity.AmbienteEntity;

import java.util.List;

public interface AmbienteRepository {
    AmbienteEntity save(Ambiente ambiente);
    Ambiente findById(Long id);
    List<Ambiente> findAll();
    void delete(Long id);
}
