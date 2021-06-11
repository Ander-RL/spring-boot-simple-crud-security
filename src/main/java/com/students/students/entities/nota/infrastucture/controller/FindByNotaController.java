package com.students.students.entities.nota.infrastucture.controller;

import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.domain.dto.NotaSearchInputDto;
import com.students.students.entities.nota.infrastucture.repository.port.FindByNotaPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Nota")
@RestController
@AllArgsConstructor
public class FindByNotaController {

    FindByNotaPort findByNotaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/nota/findby")
    public List<NotaOutputDto> findBy(@RequestBody NotaSearchInputDto notaSearchInputDto) {
        return findByNotaPort.findBy(notaSearchInputDto);
    }
}
