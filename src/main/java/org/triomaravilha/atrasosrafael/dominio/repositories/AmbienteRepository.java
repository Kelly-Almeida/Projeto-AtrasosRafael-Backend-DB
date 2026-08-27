package org.triomaravilha.atrasosrafael.dominio.repositories;



import org.triomaravilha.atrasosrafael.dominio.Ambiente;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;

import java.util.List;

public interface AmbienteRepository {
    AmbienteEntity save(AmbienteEntity ambiente);
    Ambiente findById(Long id);
    List<Ambiente> findAll();
    void deleteId(Long id);
}
