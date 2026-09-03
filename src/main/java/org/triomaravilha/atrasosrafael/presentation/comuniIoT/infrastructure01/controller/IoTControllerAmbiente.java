package org.triomaravilha.atrasosrafael.presentation.comuniIoT.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import org.triomaravilha.atrasosrafael.dominio.repository.AmbienteRepository;


@RestController
@RequestMapping("/iot/ambiente")
@RequiredArgsConstructor
public class IoTControllerAmbiente {
    private final AmbienteRepository ambienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ambiente save(@RequestBody Ambiente ambiente) {
        return this.ambienteRepository.save(ambiente);
    }


}
