package org.triomaravilha.atrasosrafael.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.model.Dashboard;
import org.triomaravilha.atrasosrafael.dominio.repository.DashboardRepository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.DashboardEntity;
import org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperDashboard;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperDashboard.mapper;

@AllArgsConstructor
@Repository
public class DashboardEntityRepository implements DashboardRepository {

    private JpaDashboardEntityRepository repository;

    @Override
    public Dashboard save(Dashboard dashboard) {
        return mapper(repository.save(mapper(dashboard)));
    }

    @Override
    public List<Dashboard> findAll() {
        List<DashboardEntity> dashboardEntity = repository.findAll();

        return StreamSupport.stream(dashboardEntity.spliterator(), false)
                .map(MapperDashboard::mapper)
                .toList();
    }

    @Override
    public Dashboard findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
