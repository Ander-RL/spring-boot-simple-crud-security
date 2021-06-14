package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.port.CreateMateriaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class CreateMateriaController {

    private final CreateMateriaPort createMateriaPort;

    @PreAuthorize("hasRole('PROFESOR')")
    @PostMapping("/api/materia/")
    public ResponseEntity<MateriaOutputDto> create(@RequestBody MateriaInputDto materiaInputDto) {

        MateriaOutputDto materiaOutputDto = createMateriaPort.create(materiaInputDto);
        return new ResponseEntity<>(materiaOutputDto, HttpStatus.OK);
    }
}
