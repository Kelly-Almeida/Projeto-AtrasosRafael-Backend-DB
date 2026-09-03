package org.triomaravilha.atrasosrafael.presentation.comuniFront.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import org.triomaravilha.atrasosrafael.dominio.repository.AmbienteRepository;


import java.util.List;


@RestController
@RequestMapping("/ambiente")
@RequiredArgsConstructor
public class ControllerAmbiente {
    private final AmbienteRepository ambienteRepository;

    @GetMapping
    public List<Ambiente> findAll() {
        return this.ambienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ambiente findById(@PathVariable Long id) {
        Ambiente amb = this.ambienteRepository.findById(id);

        if(amb == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há um ambiente com esse id");
        }

        return amb;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ambiente save(@RequestBody Ambiente ambiente) {
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
