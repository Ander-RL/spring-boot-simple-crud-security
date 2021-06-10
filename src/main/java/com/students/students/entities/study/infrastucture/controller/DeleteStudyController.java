package com.students.students.entities.study.infrastucture.controller;


import com.students.students.entities.study.infrastucture.repository.port.DeleteStudyPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Study")
@AllArgsConstructor
@RestController
public class DeleteStudyController {

    DeleteStudyPort deleteStudyPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @DeleteMapping("/api/study/{id}")
    public void deleteById(@PathVariable("id") String idStudy) {
        deleteStudyPort.deleteById(idStudy);
    }
}
