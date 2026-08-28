package org.triomaravilha.atrasosrafael.dominio.repositories;



import org.triomaravilha.atrasosrafael.dominio.Atrasos;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AtrasosEntity;

import java.util.List;

public interface AtrasosRepository {
    AtrasosEntity save(Atrasos atrasos);
    List<Atrasos> findAll();
    Atrasos findById(Long id);
    AtrasosEntity update(Atrasos atrasos, Long id);
    void delete(Atrasos atrasos);
}
