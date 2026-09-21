package org.triomaravilha.atrasosrafael.infrastructure.persistence.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure.persistence.entity.AmbienteEntity;

@Repository
public interface JpaAmbienteEntityRepository extends JpaRepository<AmbienteEntity, Long> {

}
