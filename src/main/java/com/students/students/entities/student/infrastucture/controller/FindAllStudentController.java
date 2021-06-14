package com.students.students.entities.student.infrastucture.controller;

import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.port.FindAllStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Student")
@AllArgsConstructor
@RestController
public class FindAllStudentController {

    private FindAllStudentPort findEstudiantePort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/student")
    public List<StudentOutputDto> findAll() {
        return findEstudiantePort.findAll();
    }
}
