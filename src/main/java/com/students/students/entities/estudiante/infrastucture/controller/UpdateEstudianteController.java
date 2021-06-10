package com.students.students.entities.estudiante.infrastucture.controller;


import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.UpdateEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class UpdateEstudianteController {

    private UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("/api/estudiante/{id}")
    public void update(@RequestBody EstudianteInputDto estudianteInputDto, @PathVariable("id") String id) {
        updateEstudiantePort.update(id,estudianteInputDto);
    }
}
