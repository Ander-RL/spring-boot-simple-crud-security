package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.infrastructure.repository.port.UpdatePersonaPort;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.UpdateTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class UpdatePersonaController {

    private UpdatePersonaPort updatePersonaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PutMapping("/api/persona/{id}")
    public void update(@PathVariable("id") String idPersona, @RequestBody PersonaInputDto personaInputDto) {
        updatePersonaPort.update(idPersona, personaInputDto);
    }
}
