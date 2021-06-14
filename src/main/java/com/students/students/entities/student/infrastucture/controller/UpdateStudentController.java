package com.students.students.entities.student.infrastucture.controller;


import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.infrastucture.repository.port.UpdateStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class UpdateStudentController {

    private UpdateStudentPort updateStudentPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PutMapping("/api/estudiante/{id}")
    public void update(@RequestBody StudentInputDto studentInputDto, @PathVariable("id") String id) {
        updateStudentPort.update(id, studentInputDto);
    }
}
