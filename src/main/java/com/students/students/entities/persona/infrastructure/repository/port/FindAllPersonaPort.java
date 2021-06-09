package com.students.students.entities.persona.infrastructure.repository.port;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;

import java.util.List;

public interface FindAllPersonaPort {
    List<PersonaOutputDto> findAll();
}
