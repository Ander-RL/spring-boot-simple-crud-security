package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.domain.dto.StudySearchInputDto;
import com.students.students.entities.study.infrastucture.repository.port.FindByStudyPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Study")
@RestController
@AllArgsConstructor
public class FindByStudyController {

    FindByStudyPort findByStudyPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/study/findby")
    public List<StudyOutputDto> findBy(@RequestBody StudySearchInputDto studySearchInputDto) {
        if(findByStudyPort.findBy(studySearchInputDto).isEmpty()) {
            throw new NotFoundException();
        }
        return findByStudyPort.findBy(studySearchInputDto);
    }
}
