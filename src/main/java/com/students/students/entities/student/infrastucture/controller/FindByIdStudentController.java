package com.students.students.entities.student.infrastucture.controller;


import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.port.FindByIdStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindByIdStudentController {

    FindByIdStudentPort findByIdStudentPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/estudiante/{id}")
    public StudentOutputDto findById(@PathVariable("id") String id) {
        return findByIdStudentPort.findById(id);
    }
}
