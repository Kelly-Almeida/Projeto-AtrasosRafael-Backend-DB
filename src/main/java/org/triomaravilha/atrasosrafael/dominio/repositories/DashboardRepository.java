package org.triomaravilha.atrasosrafael.dominio.repositories;



import org.triomaravilha.atrasosrafael.dominio.Dashboard;

import java.util.List;

public interface DashboardRepository  {
    Dashboard save(Dashboard dashboard);
    List<Dashboard> findAll();
    Dashboard findById(Long id);
    void delete(Dashboard dashboard);
}
