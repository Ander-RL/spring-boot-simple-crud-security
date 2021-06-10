package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.jpa.StudyRepositoryJpa;
import com.students.students.entities.study.infrastucture.repository.port.FindByIdStudyPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class FindByIdStudyRepository implements FindByIdStudyPort {

    StudyRepositoryJpa studyRepositoryJpa;

    @Override
    public StudyOutputDto findById(String idStudy) throws NotFoundException {
        return new StudyOutputDto(studyRepositoryJpa.findById(idStudy).orElseThrow(() -> new NotFoundException("No se puede encontrar Study con id -> " + idStudy)));
    }
}
