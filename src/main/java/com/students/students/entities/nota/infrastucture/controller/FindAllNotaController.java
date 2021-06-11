package com.students.students.entities.nota.infrastucture.controller;

import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.port.FindAllNotaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Nota")
@AllArgsConstructor
@RestController
public class FindAllNotaController {

    private FindAllNotaPort findAllNotaPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/nota")
    public List<NotaOutputDto> findAll() {
        return findAllNotaPort.findAll();
    }
}
