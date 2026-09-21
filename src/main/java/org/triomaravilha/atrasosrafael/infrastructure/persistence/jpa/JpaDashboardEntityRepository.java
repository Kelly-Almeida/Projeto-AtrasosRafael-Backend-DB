package org.triomaravilha.atrasosrafael.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure.persistence.entity.DashboardEntity;


@Repository
public interface JpaDashboardEntityRepository extends JpaRepository<DashboardEntity, Long> {
}
