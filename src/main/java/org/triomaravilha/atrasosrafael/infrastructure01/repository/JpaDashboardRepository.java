package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.Dashboard;
import org.triomaravilha.atrasosrafael.dominio.repositories.DashboardRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.DashboardEntity;

import java.util.List;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Repository
public class JpaDashboardRepository implements DashboardRepository {

    private DashboardEntityRepository repository;

    @Override
    public DashboardEntity save(Dashboard dashboard) {
        return repository.save(mapper(dashboard));
    }

    @Override
    public List<Dashboard> findAll() {
        List<DashboardEntity> dashboardEntity = repository.findAll();

        return StreamSupport.stream(dashboardEntity.spliterator(), false)
                .map(JpaDashboardRepository::mapper)
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

    private static Dashboard mapper(DashboardEntity entity){
        Dashboard dashboard = new Dashboard();

        dashboard.setDia(entity.getDia());
        dashboard.setMaiorTempoAtraso(entity.getMaiorTempoAtraso());
        dashboard.setTempoTotal(entity.getTempoTotal());
        dashboard.setTempoEquivAlmocos(entity.getTempoEquivAlmocos());
        dashboard.setTempoEquivFilhos(entity.getTempoEquivFilhos());

        return dashboard;
    }

    private static DashboardEntity mapper(Dashboard dashboard){
        DashboardEntity entity = new DashboardEntity();

        entity.setDia(dashboard.getDia());
        entity.setMaiorTempoAtraso(dashboard.getMaiorTempoAtraso());
        entity.setTempoTotal(dashboard.getTempoTotal());
        entity.setTempoEquivAlmocos(dashboard.getTempoEquivAlmocos());
        entity.setTempoEquivFilhos(dashboard.getTempoEquivFilhos());

        return entity;

    }
}
