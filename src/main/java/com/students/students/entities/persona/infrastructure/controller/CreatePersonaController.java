package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.port.CreatePersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.CreateTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class CreatePersonaController {

    private final CreatePersonaPort createPersonaPort;

    @PostMapping("/api/persona/")
    public ResponseEntity<PersonaOutputDto> create(@RequestBody PersonaInputDto personaInputDto){

        PersonaOutputDto personaOutputDto = createPersonaPort.create(personaInputDto);
        return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
    }
}
