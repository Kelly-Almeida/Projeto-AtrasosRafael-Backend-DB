package org.triomaravilha.atrasosrafael.dominio.repository;



import org.triomaravilha.atrasosrafael.dominio.model.Dashboard;
import java.util.List;

public interface DashboardRepository  {
    Dashboard save(Dashboard dashboard);
    List<Dashboard> findAll();
    Dashboard findById(Long id);
    void deleteById(Long id);
}
