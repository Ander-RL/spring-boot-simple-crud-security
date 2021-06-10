package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.port.CreateStudyPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Study")
@AllArgsConstructor
@RestController
public class CreateStudyController {

    private final CreateStudyPort createStudyPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/study/")
    public ResponseEntity<StudyOutputDto> create(@RequestBody StudyInputDto studyInputDto){

        StudyOutputDto studyOutputDto = createStudyPort.create(studyInputDto);
        return new ResponseEntity<>(studyOutputDto, HttpStatus.OK);
    }
}
