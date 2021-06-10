package com.students.students.entities.study.infrastucture.repository.port;


import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.domain.dto.StudyOutputDto;

public interface CreateStudyPort {
    StudyOutputDto create(StudyInputDto studyInputDto);
}
