package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.study.domain.StudyJpa;
import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.infrastucture.repository.jpa.StudyRepositoryJpa;
import com.students.students.entities.study.infrastucture.repository.port.FindByIdStudyPort;
import com.students.students.entities.study.infrastucture.repository.port.UpdateStudyPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class UpdateStudyRepository implements UpdateStudyPort {

    StudyRepositoryJpa studyRepositoryJpa;
    FindByIdStudyPort findByIdStudyPort;

    @Override
    public void update(String idStudy, StudyInputDto studyInputDto) {
        StudyJpa studyJpa = new StudyJpa(findByIdStudyPort.findById(idStudy));

        studyRepositoryJpa.save(updatedStudy(studyJpa, studyInputDto, idStudy));
    }

    private StudyJpa updatedStudy(StudyJpa studyJpa, StudyInputDto studyInputDto, String idStudy) {

        if(studyInputDto.getIdStudent() != null)
            studyJpa.setIdStudy(studyInputDto.getIdStudent());

        if(studyInputDto.getIdMateria() != null)
            studyJpa.setIdMateria(studyInputDto.getIdMateria());

        if(studyInputDto.getNote() != null)
            studyJpa.setNote(studyInputDto.getNote());

        if(studyInputDto.getComent() != null)
            studyJpa.setComent(studyInputDto.getComent());

        if(studyInputDto.getInitialDate() != null)
            studyJpa.setInitialDate(studyInputDto.getInitialDate());

        if(studyInputDto.getFinishDate() != null)
            studyJpa.setFinishDate(studyInputDto.getFinishDate());

        studyJpa.setIdStudy(idStudy);

        return studyJpa;
    }
}
