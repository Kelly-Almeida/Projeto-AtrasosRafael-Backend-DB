package org.triomaravilha.atrasosrafael.interface_ui.comuniFront.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.application.dto.dashboard.DashboardResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.DashboardRepository;


import java.util.List;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class FrontControllerDashboard {
    private final DashboardRepository dashboardRepository;

    @GetMapping
    public ResponseEntity<List<DashboardResponseDTO>> getDashboard() {
        return ResponseEntity.ok(dashboardRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DashboardResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.dashboardRepository.findById(id));
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
