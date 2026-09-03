package org.triomaravilha.atrasosrafael.infrastructure.mapper;

import org.triomaravilha.atrasosrafael.dominio.model.Dashboard;
import org.triomaravilha.atrasosrafael.infrastructure.entity.DashboardEntity;

public interface MapperDashboard {
    static Dashboard mapper(DashboardEntity entity){
        Dashboard dashboard = new Dashboard();

        dashboard.setDia(entity.getDia());
        dashboard.setMaiorTempoAtraso(entity.getMaiorTempoAtraso());
        dashboard.setTempoTotal(entity.getTempoTotal());
        dashboard.setTempoEquivAlmocos(entity.getTempoEquivAlmocos());
        dashboard.setTempoEquivFilhos(entity.getTempoEquivFilhos());

        return dashboard;
    }

    static DashboardEntity mapper(Dashboard dashboard){
        DashboardEntity entity = new DashboardEntity();

        entity.setDia(dashboard.getDia());
        entity.setMaiorTempoAtraso(dashboard.getMaiorTempoAtraso());
        entity.setTempoTotal(dashboard.getTempoTotal());
        entity.setTempoEquivAlmocos(dashboard.getTempoEquivAlmocos());
        entity.setTempoEquivFilhos(dashboard.getTempoEquivFilhos());

        return entity;

    }
}
