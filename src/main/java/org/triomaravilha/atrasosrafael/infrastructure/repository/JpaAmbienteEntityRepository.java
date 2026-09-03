package org.triomaravilha.atrasosrafael.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AmbienteEntity;

@Repository
public interface JpaAmbienteEntityRepository extends JpaRepository<AmbienteEntity, Long> {

}
