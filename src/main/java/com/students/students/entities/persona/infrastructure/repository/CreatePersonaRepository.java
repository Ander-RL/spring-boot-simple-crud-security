package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.CreatePersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreatePersonaRepository implements CreatePersonaPort {

    PersonaRepositoryJpa repository;

    @Override
    public PersonaOutputDto create(PersonaInputDto personaInputDto) {
        log.debug("Persona creada -> " + personaInputDto.toString());

        PersonaJpa personaJpa = new PersonaJpa(personaInputDto);

        repository.save(personaJpa);
        return new PersonaOutputDto(personaJpa);
    }
}
