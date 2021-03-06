package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.student.infrastucture.repository.port.FindAllStudentPort;
import com.students.students.entities.materia.infrastructure.repository.port.FindAllMateriaPort;
import com.students.students.entities.study.domain.StudyJpa;
import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.infrastucture.repository.jpa.StudyRepositoryJpa;
import com.students.students.entities.study.infrastucture.repository.port.CreateStudyPort;
import com.students.students.exception.NullException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateStudyRepository implements CreateStudyPort {

    StudyRepositoryJpa repository;
    FindAllStudentPort findAllStudentPort;
    FindAllMateriaPort findAllMateriasPort;

    @Override
    public StudyOutputDto create(StudyInputDto studyInputDto) {
        log.debug("Study creado -> " + studyInputDto.toString());

        checkNulls(studyInputDto);

        StudyJpa studyJpa = new StudyJpa(studyInputDto);
        repository.save(studyJpa);
        return new StudyOutputDto(studyJpa);
    }


    private void checkNulls(StudyInputDto studyInputDto) {
        if(studyInputDto.getNote() == null)
            throw new NullException("note no puede ser null");
        if(studyInputDto.getInitialDate() == null)
            throw new NullException("initialDate no puede ser null");
        if(studyInputDto.getFinishDate() == null)
            throw new NullException("finishDate no puede ser null");
    }



}

