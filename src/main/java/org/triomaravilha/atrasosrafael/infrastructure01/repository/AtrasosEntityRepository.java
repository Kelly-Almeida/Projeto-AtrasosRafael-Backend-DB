package org.triomaravilha.atrasosrafael.infrastructure01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AtrasosEntity;

@Repository
public interface AtrasosEntityRepository extends JpaRepository<AtrasosEntity, Long> {
}
