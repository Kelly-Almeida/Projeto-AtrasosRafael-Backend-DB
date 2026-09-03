package org.triomaravilha.atrasosrafael.presentation.comuniFront.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.dominio.model.Dashboard;
import org.triomaravilha.atrasosrafael.dominio.repository.DashboardRepository;


import java.util.List;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class ControllerDashboard {
    private final DashboardRepository dashboardRepository;

    @GetMapping
    public List<Dashboard> getDashboard() {
        return dashboardRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dashboard findById(@PathVariable Long id) {
        Dashboard dash = dashboardRepository.findById(id);

        if(dash == null){
            throw new ResourceNotFoundException("Não á nenhum registro do Dashboard com id "+ id);
        }
        return dash;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {

        if(dashboardRepository.findById(id) == null){
            throw new ResourceNotFoundException("Não á nenhum registro do Dashboard com id "+ id);
        }

        deleteById(id);
    }


}
