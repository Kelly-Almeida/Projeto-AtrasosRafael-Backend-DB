package org.triomaravilha.atrasosrafael.presentation.comuniIoT.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.dominio.model.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.repository.AtrasosRepository;

@RestController
@RequestMapping("/iot/atraso")
@RequiredArgsConstructor
public class IoTControllerAtrasos {
    private final AtrasosRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atrasos save(@RequestBody Atrasos atraso) {
        return this.repository.save(atraso);
    }

}
