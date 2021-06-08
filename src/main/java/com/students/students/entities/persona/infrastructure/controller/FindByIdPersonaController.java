package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByIdTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class FindByIdPersonaController {

    FindByIdTipoRegistroPort findByIdTipoRegistroPort;

    @GetMapping("/api/tipo_registro/{id}")
    public TipoRegistroOutputDto findById(@PathVariable("id") String idTipoRegistro) {
        return findByIdTipoRegistroPort.findById(idTipoRegistro);
    }
}
