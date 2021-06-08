package com.students.students.entities.tiporegistro.infrastructure.repository.port;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;

public interface CreateTipoRegistroPort {
    TipoRegistroOutputDto create(TipoRegistroInputDto tipoRegistroInputDto);
}
