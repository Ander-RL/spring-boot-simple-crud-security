package com.students.students.entities.study.infrastucture.repository.port;


import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.exception.NotFoundException;

public interface FindByIdStudyPort {
    StudyOutputDto findById(String idStudy) throws NotFoundException;
}
