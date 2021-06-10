package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.port.FindByIdMateriaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class FindByIdMateriaController {

    FindByIdMateriaPort findByIdMateriaPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/materia/{id}")
    public MateriaOutputDto findById(@PathVariable("id") String idMateria) {
        return findByIdMateriaPort.findById(idMateria);
    }
}
