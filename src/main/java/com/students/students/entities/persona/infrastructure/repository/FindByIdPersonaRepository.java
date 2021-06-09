package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.FindByIdPersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdPersonaRepository implements FindByIdPersonaPort {

    PersonaRepositoryJpa repository;

    @Override
    public PersonaOutputDto findById(String idPersona) {
        return new PersonaOutputDto(repository.findById(idPersona).orElseThrow(() -> new NotFoundException("No se encontro Persona con id -> " + idPersona)));
    }
}
