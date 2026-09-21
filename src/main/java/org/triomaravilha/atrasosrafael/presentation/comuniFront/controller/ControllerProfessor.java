package org.triomaravilha.atrasosrafael.presentation.comuniFront.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import org.triomaravilha.atrasosrafael.dominio.repository.ProfessorRepository;


import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ControllerProfessor {
    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> findAll(){
        return this.professorRepository.findAll();
    }

    @GetMapping("{id}")
    public Professor findById(@PathVariable Long id){
        Professor prof = this.professorRepository.findByID(id);

        if (prof == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor Not Found");
        }

        return prof;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor save(@RequestBody Professor professor){return this.professorRepository.save(professor);}

    @PutMapping("/{id}")
    public Professor update(@RequestBody Professor professor, @PathVariable Long id){
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
