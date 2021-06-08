package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.infrastructure.repository.port.DeleteMateriaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class DeleteMateriaController {

    DeleteMateriaPort deleteMateriaPort;

    @DeleteMapping("/api/materia/{id}")
    public void deleteById(@PathVariable("id") String idMateria) {
        deleteMateriaPort.deleteById(idMateria);
    }
}
