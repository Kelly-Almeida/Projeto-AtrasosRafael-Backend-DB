package org.triomaravilha.atrasosrafael.dominio.repository;



import org.triomaravilha.atrasosrafael.application.dto.dashboard.DashboardResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.model.Dashboard;
import org.triomaravilha.atrasosrafael.infrastructure.persistence.entity.DashboardEntity;

import java.util.List;

public interface DashboardRepository  {
    DashboardResponseDTO save();
    List<DashboardResponseDTO> findAll();
    DashboardResponseDTO findById(Long id);
    void deleteById(Long id);
}
