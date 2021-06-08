package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.DeleteTipoRegistroPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeleteTipoRegistroRepository implements DeleteTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;

    @Override
    public void deleteById(String idTipoRegistro) {
        repository.delete(repository.findById(idTipoRegistro).orElseThrow(() -> new NotFoundException("No se encontro TipoRegistro con id -> " + idTipoRegistro)));
    }
}
