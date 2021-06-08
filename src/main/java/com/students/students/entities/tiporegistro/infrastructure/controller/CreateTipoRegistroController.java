package com.students.students.entities.tiporegistro.infrastructure.controller;

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

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class CreateTipoRegistroController {

    private final CreateTipoRegistroPort createTipoRegistroPort;

    @PostMapping("/api/tipo_registro/")
    public ResponseEntity<TipoRegistroOutputDto> create(@RequestBody TipoRegistroInputDto tipoRegistroInputDto){

        TipoRegistroOutputDto tipoRegistroOutputDto = createTipoRegistroPort.create(tipoRegistroInputDto);
        return new ResponseEntity<>(tipoRegistroOutputDto, HttpStatus.OK);
    }
}
