package com.students.students.entities.persona.infrastructure.repository.port;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;

public interface CreatePersonaPort {
    PersonaOutputDto create(PersonaInputDto personaInputDto);
}
