package org.triomaravilha.atrasosrafael.interface_ui.comuniFront.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.AmbienteRepository;


import java.util.List;


@RestController
@RequestMapping("/ambiente")
@RequiredArgsConstructor
public class FrontControllerAmbiente {
    private final AmbienteRepository ambienteRepository;

    @GetMapping
    public ResponseEntity<List<AmbienteResponseDTO>> findAll() {
        return ResponseEntity.ok(this.ambienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.ambienteRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AmbienteResponseDTO save(@Valid @RequestBody AmbienteRequestDTO ambiente) {
        return this.ambienteRepository.save(ambiente);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        if(this.ambienteRepository.findById(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ambiente com id " + id);
        }

        this.ambienteRepository.deleteId(id);
    }


}
