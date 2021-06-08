package com.students.students.entities.tiporegistro.infrastructure.repository.port;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;

import java.util.List;

public interface FindAllTipoRegistroPort {
    List<TipoRegistroOutputDto> findAll();
}
