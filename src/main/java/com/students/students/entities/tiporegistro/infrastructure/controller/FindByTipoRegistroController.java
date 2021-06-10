package com.students.students.entities.tiporegistro.infrastructure.controller;

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

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class FindByTipoRegistroController {

    FindByTipoRegistroPort findByTipoRegistroPort;

    @PreAuthorize("hasRole('PROFESOR')")
    @PostMapping("/api/tipo_registro/findby")
    List<TipoRegistroOutputDto> findBy(@RequestBody TipoRegistroSearchInputDto tipoRegistroSearchInputDto){
        if(findByTipoRegistroPort.findBy(tipoRegistroSearchInputDto).isEmpty()) {
            throw new NotFoundException();
        }
        return findByTipoRegistroPort.findBy(tipoRegistroSearchInputDto);
    }
}
