package com.students.students.entities.persona.infrastructure.controller;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByTipoRegistroPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class FindByPersonaController {

    FindByTipoRegistroPort findByTipoRegistroPort;

    @PostMapping("/api/tipo_registro/findby")
    List<TipoRegistroOutputDto> findBy(@RequestBody TipoRegistroSearchInputDto tipoRegistroSearchInputDto){
        if(findByTipoRegistroPort.findBy(tipoRegistroSearchInputDto).isEmpty()) {
            throw new NotFoundException();
        }
        return findByTipoRegistroPort.findBy(tipoRegistroSearchInputDto);
    }
}
