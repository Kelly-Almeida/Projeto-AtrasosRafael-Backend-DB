package org.triomaravilha.atrasosrafael.interface_ui.comuniIoT.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.Ambiente.AmbienteResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.AmbienteRepository;

import java.net.URI;


@RestController
@RequestMapping("/iot/ambiente")
@RequiredArgsConstructor
public class IoTControllerAmbiente {
    private final AmbienteRepository ambienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AmbienteResponseDTO> save(@RequestBody AmbienteRequestDTO ambiente) {
        AmbienteResponseDTO ambSafe = ambienteRepository.save(ambiente);

        return ResponseEntity.created(
                URI.create("/ambiente/" + ambSafe.id())
        ).body(ambSafe);

    }


}
