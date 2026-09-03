package org.triomaravilha.atrasosrafael.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.triomaravilha.atrasosrafael.dominio.model.Professor;
import org.triomaravilha.atrasosrafael.dominio.repository.ProfessorRepository;
import org.triomaravilha.atrasosrafael.infrastructure.entity.ProfessorEntity;
import org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperProfessor;


import java.util.List;
import java.util.stream.StreamSupport;

import static org.triomaravilha.atrasosrafael.infrastructure.mapper.MapperProfessor.mapper;

@Repository
@AllArgsConstructor
public class ProfessorEntityRepository implements ProfessorRepository {
    private final JpaProfessorEntityRepository professorEntityRepository;

    @Override
    public void delete(Long id) {
        professorEntityRepository.deleteById(id);
    }

    @Override
    public Professor save(Professor professor) {
       return mapper(professorEntityRepository.save(mapper(professor)));
    }

    @Override
    public List<Professor> findAll() {
        Iterable<ProfessorEntity> entities = professorEntityRepository.findAll();

        return StreamSupport.stream(entities.spliterator(), false)
                .map(MapperProfessor::mapper).toList();
    }

    @Override
    public Professor findByID(Long id) {
        return professorEntityRepository.findById(id).stream().map(MapperProfessor::mapper).findFirst().orElse(null);
    }

    @Override
    public Professor update(Professor professor, Long id) {
        Professor professores = findByID(id);

        professores.setId(professor.getId());
        professores.setNome(professor.getNome());
        professor.setFoto(professor.getFoto());

        return mapper(professorEntityRepository.save(mapper(professores)));
    }


}
