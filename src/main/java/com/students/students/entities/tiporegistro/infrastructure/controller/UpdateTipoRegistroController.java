package com.students.students.entities.tiporegistro.infrastructure.controller;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.UpdateTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class UpdateTipoRegistroController {

    private UpdateTipoRegistroPort updateTipoRegistroPort;

    @PutMapping("/api/tipo_registro/{id}")
    public void update(@PathVariable("id") String idTipoRegistro, @RequestBody TipoRegistroInputDto tipoRegistroInputDto) {
        updateTipoRegistroPort.update(idTipoRegistro, tipoRegistroInputDto);
    }
}
