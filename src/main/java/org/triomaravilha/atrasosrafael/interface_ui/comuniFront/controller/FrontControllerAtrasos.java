package org.triomaravilha.atrasosrafael.interface_ui.comuniFront.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.atraso.AtrasosResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.AtrasosRepository;

import java.util.List;

@RestController
@RequestMapping("/atraso")
@RequiredArgsConstructor
public class FrontControllerAtrasos {
    private final AtrasosRepository repository;

    @GetMapping
    public ResponseEntity<List<AtrasosResponseDTO>> findAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtrasosResponseDTO> findById(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.repository.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtrasosResponseDTO save(@RequestBody AtrasosRequestDTO atraso) {
        return this.repository.save(atraso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        //Tratar isso
        if(this.repository.findById(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro com id " + id);
        }

        this.repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public AtrasosResponseDTO update(@PathVariable Long id, @RequestBody AtrasosRequestDTO atraso){
        return repository.update(atraso, id);
    }
}
