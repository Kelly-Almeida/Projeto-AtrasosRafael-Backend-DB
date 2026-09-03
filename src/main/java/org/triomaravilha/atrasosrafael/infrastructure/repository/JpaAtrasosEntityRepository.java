package org.triomaravilha.atrasosrafael.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.AtrasosEntity;

@Repository
public interface JpaAtrasosEntityRepository extends JpaRepository<AtrasosEntity, Long> {
}
