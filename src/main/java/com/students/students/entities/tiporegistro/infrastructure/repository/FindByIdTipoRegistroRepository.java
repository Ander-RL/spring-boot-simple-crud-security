package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByIdTipoRegistroPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdTipoRegistroRepository implements FindByIdTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;

    @Override
    public TipoRegistroOutputDto findById(String idTipoRegistro) {
        return new TipoRegistroOutputDto(repository.findById(idTipoRegistro).orElseThrow(() -> new NotFoundException("No se encontro TipoRegistro con id -> " + idTipoRegistro)));
    }
}
