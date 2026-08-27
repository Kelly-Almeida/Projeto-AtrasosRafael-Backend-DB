package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import triomaravilha.atrasosrafael.infrastructure01.entity.ProfessorEntity;

@Repository
public interface ProfessorEntityRepository extends JpaRepository<ProfessorEntity, Long> {
}
