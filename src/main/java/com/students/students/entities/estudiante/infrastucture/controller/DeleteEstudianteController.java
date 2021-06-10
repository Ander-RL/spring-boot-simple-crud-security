package com.students.students.entities.estudiante.infrastucture.controller;


import com.students.students.entities.estudiante.infrastucture.repository.port.DeleteEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class DeleteEstudianteController {

    DeleteEstudiantePort deleteEstudiantePort;
    @PreAuthorize("hasRole('PROFESOR')")
    @DeleteMapping("/api/estudiante/{id_estudiante}")
    public void deleteByID(@PathVariable("id_estudiante") String idEstudiante){
        deleteEstudiantePort.deleteById(idEstudiante);
    }
}
