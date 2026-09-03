package org.triomaravilha.atrasosrafael.dominio.repository;

import org.triomaravilha.atrasosrafael.dominio.model.Atrasos;
import java.util.List;

public interface AtrasosRepository {
    Atrasos save(Atrasos atrasos);
    List<Atrasos> findAll();
    Atrasos findById(Long id);
    Atrasos update(Atrasos atrasos, Long id);
    void deleteById(Long id);
}
