package org.triomaravilha.atrasosrafael.infrastructure01.repository;

import org.springframework.stereotype.Repository;
import triomaravilha.atrasosrafael.dominio.Professor;
import triomaravilha.atrasosrafael.dominio.repositories.ProfessorRepository;
import triomaravilha.atrasosrafael.infrastructure01.entity.ProfessorEntity;
import triomaravilha.atrasosrafael.infrastructure01.repository.ProfessorEntityRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class JpaProfessorRepository implements ProfessorRepository {
    private final ProfessorEntityRepository professorEntityRepository;

    public JpaProfessorRepository(ProfessorEntityRepository professorEntityRepository) {
        this.professorEntityRepository = professorEntityRepository;
    }

    @Override
    public void delete(Long id) {
        professorEntityRepository.deleteById(id);
    }

    @Override
    public ProfessorEntity save(Professor professor) {
        ProfessorEntity entity = mapper(professor);

        return professorEntityRepository.save(entity);
    }

    @Override
    public List<Professor> findAll() {
        Iterable<ProfessorEntity> entities = professorEntityRepository.findAll();

        return StreamSupport.stream(entities.spliterator(), false)
                .map(JpaProfessorRepository::mapper).toList();
    }

    @Override
    public Professor findByID(Long id) {
        return professorEntityRepository.findById(id).stream().map(JpaProfessorRepository::mapper).findFirst().orElse(null);
    }

    @Override
    public ProfessorEntity update(Professor professor, Long id) {
        Professor professores = findByID(id);

        professores.setId(professor.getId());
        professores.setNome(professor.getNome());
        professor.setFoto(professor.getFoto());

        return professorEntityRepository.save(mapper(professores));
    }

    private ProfessorEntity mapper(Professor professor) {
        ProfessorEntity professorEntity = new ProfessorEntity();

        professorEntity.setId(professor.getId());
        professorEntity.setNome(professor.getNome());
        professorEntity.setFoto(professor.getFoto());

        return professorEntity;
    }

    private static Professor mapper(ProfessorEntity professorEntity) {
        Professor professor = new Professor();

        professor.setId(professorEntity.getId());
        professor.setNome(professorEntity.getNome());
        professor.setFoto(professorEntity.getFoto());

        return professor;
    }
}
