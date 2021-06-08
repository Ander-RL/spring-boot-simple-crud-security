package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.students.students.entities.persona.infrastructure.repository.port.FindAllPersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllPersonaRepository implements FindAllPersonaPort {

    PersonaRepositoryJpa repository;

    @Override
    public List<PersonaOutputDto> findAll() {

        List<PersonaOutputDto> listOut = new ArrayList<>();
        List<PersonaJpa> listIn = repository.findAll();

        for(PersonaJpa persona : listIn) {
            listOut.add(new PersonaOutputDto(persona));
        }
        return listOut;
    }
}
