package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.port.FindByIdStudyPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Study")
@AllArgsConstructor
@RestController
public class FindByIdStudyController {

    FindByIdStudyPort findByIdStudyPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/study/{id}")
    public StudyOutputDto findById(@PathVariable("id") String idStudy) {

        return findByIdStudyPort.findById(idStudy);
    }
}
