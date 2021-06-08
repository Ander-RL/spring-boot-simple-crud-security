package com.students.students.entities.tiporegistro.infrastructure.repository.port;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;
import java.util.List;

public interface FindByTipoRegistroPort {
    List<TipoRegistroOutputDto> findBy(TipoRegistroSearchInputDto tipoRegistroSearchInputDto);
}
