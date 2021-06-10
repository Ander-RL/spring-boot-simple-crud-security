package com.students.students.entities.study.infrastucture.repository.port;



import com.students.students.entities.study.domain.dto.StudyOutputDto;

import java.util.List;

public interface FindAllStudyPort {
    List<StudyOutputDto> findAll();
}
