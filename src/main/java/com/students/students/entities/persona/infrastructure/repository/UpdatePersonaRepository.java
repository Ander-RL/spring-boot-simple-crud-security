package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.FindByIdPersonaPort;
import com.students.students.entities.persona.infrastructure.repository.port.UpdatePersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.exception.InvalidDateException;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@AllArgsConstructor
@Repository
public class UpdatePersonaRepository implements UpdatePersonaPort {

    PersonaRepositoryJpa repository;
    FindByIdPersonaPort findByIdTipoRegistroPort;

    @Override
    public void update(String idPersona, PersonaInputDto personaInputDto) {
        log.debug("editando Persona " + idPersona);
        PersonaJpa personaJpa = new PersonaJpa(findByIdTipoRegistroPort.findById(idPersona));

        repository.save(updatedPersona(personaJpa, personaInputDto, idPersona));
    }

    private PersonaJpa updatedPersona(PersonaJpa personaJpa, PersonaInputDto personaInputDto, String idPersona) {

        if (personaInputDto.getUser() != null)
            personaJpa.setUser(personaInputDto.getUser());

        if (personaInputDto.getPassword() != null)
            personaJpa.setPassword(personaInputDto.getPassword());

        if (personaInputDto.getSurname() != null)
            personaJpa.setSurname(personaInputDto.getSurname());

        if (personaInputDto.getCompanyEmail() != null)
            personaJpa.setCompanyEmail(personaInputDto.getCompanyEmail());

        if (personaInputDto.getPersonalEmail() != null)
            personaJpa.setPersonalEmail(personaInputDto.getPersonalEmail());

        if (personaInputDto.getCity() != null)
            personaJpa.setCity(personaInputDto.getCity());

        if (personaInputDto.getActive() != null)
            personaJpa.setActive(personaInputDto.getActive());

        if (personaInputDto.getCreatedDate() != null)
            personaJpa.setCreatedDate(personaInputDto.getCreatedDate());

        if (personaInputDto.getTerminationDate() != null)
            personaJpa.setTerminationDate(personaInputDto.getTerminationDate());

        personaJpa.setIdPersona(idPersona);

        return personaJpa;
    }
}
