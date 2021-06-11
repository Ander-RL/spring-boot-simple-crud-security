package com.students.students.entities.nota.infrastucture.controller;

import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.port.FindByIdNotaPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Nota")
@AllArgsConstructor
@RestController
public class FindByIdNotaController {

    private FindByIdNotaPort findByIdNotaPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/nota/{id}")
    public NotaOutputDto findById(@PathVariable("id") String idNota) throws NotFoundException {
        return findByIdNotaPort.findById(idNota);
    }
}
