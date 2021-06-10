package com.students.students.entities.study.infrastucture.repository.port;


import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.domain.dto.StudySearchInputDto;

import java.util.List;

public interface FindByStudyPort {
    List<StudyOutputDto> findBy(StudySearchInputDto studySearchInputDto);
}
