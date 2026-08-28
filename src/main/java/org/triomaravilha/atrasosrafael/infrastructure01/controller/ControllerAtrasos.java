package org.triomaravilha.atrasosrafael.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.dominio.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.repositories.AtrasosRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AmbienteEntity;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.AtrasosEntity;

import java.util.List;

@RestController
@RequestMapping("/atraso")
@RequiredArgsConstructor
public class ControllerAtrasos {
    private final AtrasosRepository repository;

    @GetMapping
    public List<Atrasos> findAll(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Atrasos findById(@PathVariable Long id){
        Atrasos atraso = this.repository.findById(id);

        if (atraso == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro com id " + id + " encontrado.");
        }
        return atraso;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtrasosEntity save(@RequestBody AtrasosEntity atraso) {
        return this.repository.save(atraso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        if(this.repository.findById(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro com id " + id);
        }

        this.repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Atrasos atraso){
        this.repository.update(atraso, id);
    }
}
