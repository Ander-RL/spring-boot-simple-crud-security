package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.persona.infrastructure.repository.port.DeletePersonaPort;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.DeleteTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Persona")
@AllArgsConstructor
@RestController
public class DeletePersonaController {

    DeletePersonaPort deletePersonaPort;

    @DeleteMapping("/api/persona/{id}")
    public void deleteById(@PathVariable("id") String idPersona) {
        deletePersonaPort.deleteById(idPersona);
    }
}
