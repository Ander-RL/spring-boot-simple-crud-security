package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.DeletePersonaPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeletePersonaRepository implements DeletePersonaPort {

    PersonaRepositoryJpa repository;

    @Override
    public void deleteById(String idPersona) {
        repository.delete(repository.findById(idPersona).orElseThrow(() -> new NotFoundException("No se encontro Persona con id -> " + idPersona)));
    }
}
