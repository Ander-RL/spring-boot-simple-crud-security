package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.port.FindAllMateriaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class FindAllMateriaController {

    private final FindAllMateriaPort findAllMateriaPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/materia/")
    public List<MateriaOutputDto> findAll(){
        return findAllMateriaPort.findAll();
    }
}
