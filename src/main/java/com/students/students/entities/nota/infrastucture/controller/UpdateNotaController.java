package com.students.students.entities.nota.infrastucture.controller;

import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.infrastucture.repository.port.UpdateNotaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Nota")
@RestController
@AllArgsConstructor
public class UpdateNotaController {

    private UpdateNotaPort updateNotaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PutMapping("/api/nota/{id}")
    public void update(@PathVariable("id") String idNota,@RequestBody NotaInputDto notaInputDto) {
        updateNotaPort.update(idNota,notaInputDto);
    }
}
