package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.DashboardEntity;


@Repository
public interface DashboardEntityRepository extends JpaRepository<DashboardEntity, Long> {
}
