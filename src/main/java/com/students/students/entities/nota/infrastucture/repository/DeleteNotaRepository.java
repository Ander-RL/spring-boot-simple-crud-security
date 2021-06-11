package com.students.students.entities.nota.infrastucture.repository;

import com.students.students.entities.nota.infrastucture.repository.jpa.NotaRepositoryJpa;
import com.students.students.entities.nota.infrastucture.repository.port.DeleteNotaPort;
import com.students.students.entities.nota.infrastucture.repository.port.FindByIdNotaPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class DeleteNotaRepository implements DeleteNotaPort {

    NotaRepositoryJpa repository;
    FindByIdNotaPort findByIdNotaPort;

    @Override
    public void deleteById(String idNota) {
        log.debug("borrando nota " + idNota);
        repository.deleteById(idNota);
    }
}
