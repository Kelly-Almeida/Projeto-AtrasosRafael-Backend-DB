package org.triomaravilha.atrasosrafael.dominio.repository;
import org.triomaravilha.atrasosrafael.dominio.model.Ambiente;
import java.util.List;

public interface AmbienteRepository {
    Ambiente save(Ambiente ambiente);
    Ambiente findById(Long id);
    List<Ambiente> findAll();
    void deleteId(Long id);
}
