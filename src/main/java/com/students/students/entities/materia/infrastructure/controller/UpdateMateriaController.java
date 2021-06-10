package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.infrastructure.repository.port.UpdateMateriaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class UpdateMateriaController {

    private UpdateMateriaPort updateMateriaPort;
    @PreAuthorize("hasRole('PROFESOR')")
    @PutMapping("/api/materia/{id}")
    public void update(@PathVariable("id") String idMateria, @RequestBody MateriaInputDto materiaInputDto) {
        updateMateriaPort.update(idMateria, materiaInputDto);
    }
}
