package org.triomaravilha.atrasosrafael.infrastructure01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;

@Repository
public interface AtrasoasEntityRepository extends JpaRepository<AmbienteEntity, Long> {
}
