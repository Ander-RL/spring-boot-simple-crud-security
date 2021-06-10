package com.students.students.entities.estudiante.infrastucture.controller;

import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.CreateEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private final CreateEstudiantePort createEstudiantePort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/estudiante/")
    public ResponseEntity<EstudianteOutputDto> create(@RequestBody EstudianteInputDto estudianteInputDto){

        EstudianteOutputDto estudianteOutputDto = createEstudiantePort.create(estudianteInputDto);
        return new ResponseEntity<>(estudianteOutputDto,HttpStatus.OK);
    }
}
