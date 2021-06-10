package com.students.students.entities.estudiante.infrastucture.controller;


import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteSearchInputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByEstudiantePort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class FindByEstudianteController {

    FindByEstudiantePort findByEstudiantePort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/estudiante/findby")
    public List<EstudianteOutputDto> findBy(@RequestBody EstudianteSearchInputDto estudianteSearchInputDto) {
        return findByEstudiantePort.findBy(estudianteSearchInputDto);
    }
}
