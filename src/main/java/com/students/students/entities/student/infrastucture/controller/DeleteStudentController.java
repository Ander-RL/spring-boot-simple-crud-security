package com.students.students.entities.student.infrastucture.controller;


import com.students.students.entities.student.infrastucture.repository.port.DeleteStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class DeleteStudentController {

    DeleteStudentPort deleteStudentPort;
    @PreAuthorize("hasRole('PROFESOR')")
    @DeleteMapping("/api/estudiante/{id_estudiante}")
    public void deleteByID(@PathVariable("id_estudiante") String idEstudiante){
        deleteStudentPort.deleteById(idEstudiante);
    }
}
