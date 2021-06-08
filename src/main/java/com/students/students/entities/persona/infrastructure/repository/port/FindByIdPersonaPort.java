package com.students.students.entities.persona.infrastructure.repository.port;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;

public interface FindByIdPersonaPort {
    PersonaOutputDto findById(String idPersona);
}
