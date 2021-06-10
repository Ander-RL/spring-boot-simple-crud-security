package com.students.students.entities.tiporegistro.infrastructure.controller;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindAllTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class FindAllTipoRegistroController {

    private final FindAllTipoRegistroPort findAllTipoRegistroPort;

    @PreAuthorize("hasRole('PROFESOR')")
    @GetMapping("/api/tipo_registro/")
    public List<TipoRegistroOutputDto> findAll(){
        return findAllTipoRegistroPort.findAll();
    }
}
