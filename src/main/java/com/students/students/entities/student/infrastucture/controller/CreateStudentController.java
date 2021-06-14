package com.students.students.entities.student.infrastucture.controller;

import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.port.CreateStudentPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Student")
@AllArgsConstructor
@RestController
public class CreateStudentController {

    private final CreateStudentPort createStudentPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/student/")
    public ResponseEntity<StudentOutputDto> create(@RequestBody StudentInputDto studentInputDto){

        StudentOutputDto studentOutputDto = createStudentPort.create(studentInputDto);
        return new ResponseEntity<>(studentOutputDto,HttpStatus.OK);
    }
}
