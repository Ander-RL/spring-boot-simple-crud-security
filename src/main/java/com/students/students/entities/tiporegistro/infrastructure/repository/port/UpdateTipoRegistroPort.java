package com.students.students.entities.tiporegistro.infrastructure.repository.port;


import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;

public interface UpdateTipoRegistroPort {
    void update(String idTipoRegistro, TipoRegistroInputDto tipoRegistroInputDto);
}
