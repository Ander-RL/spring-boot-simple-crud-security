package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.domain.dto.PersonaSearchInputDto;
import com.students.students.entities.persona.infrastructure.repository.port.FindByPersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByTipoRegistroPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class FindByPersonaController {

    FindByPersonaPort findByPersonaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/persona/findby")
    List<PersonaOutputDto> findBy(@RequestBody PersonaSearchInputDto personaSearchInputDto){
        return findByPersonaPort.findBy(personaSearchInputDto);
    }
}
