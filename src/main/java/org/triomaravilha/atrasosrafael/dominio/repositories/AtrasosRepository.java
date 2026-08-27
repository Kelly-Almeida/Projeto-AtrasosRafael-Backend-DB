package org.triomaravilha.atrasosrafael.dominio.repositories;

import triomaravilha.atrasosrafael.dominio.Atrasos;

import java.util.List;

public interface AtrasosRepository {
    Atrasos save(Atrasos atrasos);
    List<Atrasos> findAll();
    Atrasos findById(Long id);
    Atrasos update(Atrasos atrasos, Long id);
    void delete(Atrasos atrasos);
}
