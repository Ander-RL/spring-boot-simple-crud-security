package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.infrastucture.repository.port.UpdateStudyPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Study")
@RestController
@AllArgsConstructor
public class UpdateStudyController {

    UpdateStudyPort updateStudyPort;

    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PutMapping("/api/study/{id}")
    public void update(@RequestBody StudyInputDto studyInputDto, @PathVariable("id") String idStudy) {
        updateStudyPort.update(idStudy,studyInputDto);
    }
}
