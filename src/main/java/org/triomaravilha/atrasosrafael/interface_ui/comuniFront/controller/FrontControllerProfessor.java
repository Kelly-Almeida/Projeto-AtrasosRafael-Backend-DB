package org.triomaravilha.atrasosrafael.interface_ui.comuniFront.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.application.dto.professor.ProfessorRequestDTO;
import org.triomaravilha.atrasosrafael.application.dto.professor.ProfessorResponseDTO;
import org.triomaravilha.atrasosrafael.dominio.repository.ProfessorRepository;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class FrontControllerProfessor {
    private final ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> findAll(){
        return ResponseEntity.ok(this.professorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(professorRepository.findByID(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorResponseDTO> save(@Valid @RequestBody ProfessorRequestDTO professor){
        ProfessorResponseDTO professorSafe = professorRepository.save(professor);

        return ResponseEntity.created(
                URI.create("/professor/" +  professorSafe.id())
        ).body(professorSafe);
    }

    @PutMapping("/{id}")
    public ProfessorResponseDTO update(@RequestBody ProfessorRequestDTO professor, @PathVariable Long id){
        return professorRepository.update(professor, id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        if(professorRepository.findByID(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor com id" + id + " não foi encontrado.");
        }

        this.professorRepository.delete(id);
    }

}
