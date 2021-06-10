package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.study.infrastucture.repository.jpa.StudyRepositoryJpa;
import com.students.students.entities.study.infrastucture.repository.port.DeleteStudyPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeleteStudyRepository implements DeleteStudyPort {

    StudyRepositoryJpa studyRepositoryJpa;

    @Override
    public void deleteById(String idStudy) {
        studyRepositoryJpa.delete(studyRepositoryJpa.findById(idStudy).orElseThrow(() -> new NotFoundException("No se puede encontrar Study con id -> " + idStudy)));
    }
}
