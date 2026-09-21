package org.triomaravilha.atrasosrafael.interface_ui.comuniIoT.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.AtrasosRepository;

@RestController
@RequestMapping("/iot/atraso")
@RequiredArgsConstructor
public class IoTControllerAtrasos {
    private final AtrasosRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtrasosResponseDTO save(@RequestBody AtrasosRequestDTO atraso) {
        return this.repository.save(atraso);
    }

}
