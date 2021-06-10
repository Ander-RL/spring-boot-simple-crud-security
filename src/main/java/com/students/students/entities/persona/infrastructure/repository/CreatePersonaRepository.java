package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.CreatePersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.exception.InvalidDateException;
import com.students.students.exception.NullException;
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
public class CreatePersonaRepository implements CreatePersonaPort {

    PersonaRepositoryJpa repository;

    @Override
    public PersonaOutputDto create(PersonaInputDto personaInputDto) {
        log.debug("Persona creada -> " + personaInputDto.toString());

        checkNulls(personaInputDto);
        checkIfDatesAreCorrect(personaInputDto);

        PersonaJpa personaJpa = new PersonaJpa(personaInputDto);

        repository.save(personaJpa);
        return new PersonaOutputDto(personaJpa);
    }

    private void checkNulls(PersonaInputDto personaInputDto) {
        if (personaInputDto.getUser() == null)
            throw new NullException("user no puede ser null");
        if (personaInputDto.getSurname() == null)
            throw new NullException("surname no puede ser null");
        if (personaInputDto.getCompanyEmail() == null)
            throw new NullException("companyEmail no puede ser null");
        if (personaInputDto.getPersonalEmail() == null)
            throw new NullException("personalEmail no puede ser null");
        if (personaInputDto.getCity() == null)
            throw new NullException("city no puede ser null");
        if (personaInputDto.getActive() == null)
            throw new NullException("active no puede ser null");
        if (personaInputDto.getCreatedDate() == null)
            throw new NullException("createDate no puede ser null");
        if (personaInputDto.getTerminationDate() == null)
            throw new NullException("terminationDate no puede ser null");
    }

    private void checkIfDatesAreCorrect(PersonaInputDto personaInputDto) {
        if (!personaInputDto.getTerminationDate().after(personaInputDto.getCreatedDate())) {
            throw new InvalidDateException(
                    "createDate debe ser inferior a terminationDate");
        }
    }
}
