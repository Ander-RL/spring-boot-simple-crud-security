package com.students.students.entities.tiporegistro.infrastructure.controller;

import com.students.students.entities.tiporegistro.infrastructure.repository.port.DeleteTipoRegistroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "TipoRegistro")
@AllArgsConstructor
@RestController
public class DeleteTipoRegistroController {

    DeleteTipoRegistroPort deleteTipoRegistroPort;

    @PreAuthorize("hasRole('PROFESOR')")
    @DeleteMapping("/api/tipo_registro/{id}")
    public void deleteById(@PathVariable("id") String idTipoRegistro) {
        deleteTipoRegistroPort.deleteById(idTipoRegistro);
    }
}
