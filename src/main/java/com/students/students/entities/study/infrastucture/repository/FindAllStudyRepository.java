package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.study.domain.StudyJpa;
import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.jpa.StudyRepositoryJpa;
import com.students.students.entities.study.infrastucture.repository.port.FindAllStudyPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllStudyRepository implements FindAllStudyPort {

    StudyRepositoryJpa studyRepositoryJpa;

    @Override
    public List<StudyOutputDto> findAll() {

        List<StudyOutputDto> listOut = new ArrayList<>();
        List<StudyJpa> listIn = studyRepositoryJpa.findAll();

        for(StudyJpa studyJpa : listIn){
            listOut.add(new StudyOutputDto(studyJpa));
        }
        return listOut;
    }
}
