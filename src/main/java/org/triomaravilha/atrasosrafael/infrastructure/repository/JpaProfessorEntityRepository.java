package org.triomaravilha.atrasosrafael.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;


@Repository
public interface JpaProfessorEntityRepository extends JpaRepository<ProfessorEntity, Long> {
}
