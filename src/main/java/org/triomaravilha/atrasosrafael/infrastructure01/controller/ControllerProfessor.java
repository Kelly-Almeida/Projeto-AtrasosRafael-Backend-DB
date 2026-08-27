package org.triomaravilha.atrasosrafael.infrastructure01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.triomaravilha.atrasosrafael.dominio.Professor;
import org.triomaravilha.atrasosrafael.dominio.repositories.ProfessorRepository;
import org.triomaravilha.atrasosrafael.infrastructure01.entity.ProfessorEntity;


import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ControllerProfessor{
    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> findAll(){
        return this.professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Long id){
        return this.professorRepository.findByID(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorEntity save(@RequestBody Professor professor){return this.professorRepository.save(professor);}

    @PutMapping("/{id}")
    public ProfessorEntity update(@RequestBody Professor professor, @PathVariable Long id){
        return professorRepository.update(professor, id);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        this.professorRepository.delete(id);
    }

}
