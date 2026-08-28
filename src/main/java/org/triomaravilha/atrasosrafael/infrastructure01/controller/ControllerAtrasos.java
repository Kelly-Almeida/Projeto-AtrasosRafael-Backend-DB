package org.triomaravilha.atrasosrafael.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.triomaravilha.atrasosrafael.dominio.Atrasos;
import org.triomaravilha.atrasosrafael.dominio.repositories.AtrasosRepository;

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


}
