package com.students.students.entities.persona.infrastructure.repository.port;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.domain.dto.PersonaSearchInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;

import java.util.List;

public interface FindByPersonaPort {
    List<PersonaOutputDto> findBy(PersonaSearchInputDto personaSearchInputDto);
}
