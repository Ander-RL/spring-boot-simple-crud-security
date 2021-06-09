package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.port.FindAllPersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindAllTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class FindAllPersonaController {

    private final FindAllPersonaPort findAllPersonaPort;

    @GetMapping("/api/persona/")
    public List<PersonaOutputDto> findAll(){
        return findAllPersonaPort.findAll();
    }
}
