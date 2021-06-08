package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.FindByIdPersonaPort;
import com.students.students.entities.persona.infrastructure.repository.port.UpdatePersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.exception.InvalidDateException;
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

         // TODO actualizar campos
//
//        if (tipoRegistroInputDto.getName() != null)
//            tipoRegistroJpa.setName(tipoRegistroInputDto.getName());
//
//        if (tipoRegistroInputDto.getLastUpdate() != null)
//            tipoRegistroJpa.setLastUpdate(date);
//
//        if (tipoRegistroInputDto.getActivo() != null)
//            tipoRegistroJpa.setActivo(tipoRegistroInputDto.getActivo());
//
//        tipoRegistroJpa.setIdTipoRegistro(idTipoRegistro);

        return personaJpaaaaaa;
    }
}
