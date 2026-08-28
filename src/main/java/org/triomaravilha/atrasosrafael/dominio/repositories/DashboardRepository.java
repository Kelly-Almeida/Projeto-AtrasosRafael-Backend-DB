package org.triomaravilha.atrasosrafael.dominio.repositories;



import org.triomaravilha.atrasosrafael.dominio.Dashboard;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.DashboardEntity;

import java.util.List;

public interface DashboardRepository  {
    DashboardEntity save(Dashboard dashboard);
    List<Dashboard> findAll();
    Dashboard findById(Long id);
    void deleteById(Long id);
}
