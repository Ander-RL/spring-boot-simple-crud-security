package com.students.students.entities.persona.infrastructure.repository.port;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;

public interface UpdatePersonaPort {
    void update(String idPersona, PersonaInputDto personaInputDto);
}
