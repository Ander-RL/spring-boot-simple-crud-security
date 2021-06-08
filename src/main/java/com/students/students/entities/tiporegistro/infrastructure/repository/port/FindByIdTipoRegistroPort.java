package com.students.students.entities.tiporegistro.infrastructure.repository.port;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;

public interface FindByIdTipoRegistroPort {
    TipoRegistroOutputDto findById(String idTipoRegistro);
}
