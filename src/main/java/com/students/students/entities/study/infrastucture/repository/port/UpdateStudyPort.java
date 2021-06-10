package com.students.students.entities.study.infrastucture.repository.port;


import com.students.students.entities.study.domain.dto.StudyInputDto;

public interface UpdateStudyPort {
    void update(String idStudy, StudyInputDto studyInputDto);
}
