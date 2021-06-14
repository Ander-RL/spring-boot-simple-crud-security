package com.students.students.entities.student.infrastucture.controller;


import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.domain.dto.StudentSearchInputDto;
import com.students.students.entities.student.infrastucture.repository.port.FindByStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class FindByStudentController {

    FindByStudentPort findByStudentPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/estudiante/findby")
    public List<StudentOutputDto> findBy(@RequestBody StudentSearchInputDto studentSearchInputDto) {
        return findByStudentPort.findBy(studentSearchInputDto);
    }
}
