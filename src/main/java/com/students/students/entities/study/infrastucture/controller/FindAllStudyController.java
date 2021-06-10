package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.port.FindAllStudyPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Study")
@AllArgsConstructor
@RestController
public class FindAllStudyController {

    FindAllStudyPort findAllStudyPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/study")
    public List<StudyOutputDto> findAll() {
        return findAllStudyPort.findAll();
    }
}
