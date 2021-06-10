package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.infrastructure.repository.port.FindByIdPersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByIdTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class FindByIdPersonaController {

    FindByIdPersonaPort findByIdPersonaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/persona/{id}")
    public PersonaOutputDto findById(@PathVariable("id") String idPersona) {
        return findByIdPersonaPort.findById(idPersona);
    }
}
