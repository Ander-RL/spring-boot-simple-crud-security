package com.students.students.entities.study.domain.dto;


import com.students.students.entities.study.domain.StudyJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudyInputDto {

    public StudyInputDto(StudyJpa studyJpa) {
        this.idStudent = studyJpa.getIdStudent();
        this.idMateria = studyJpa.getIdMateria();
        this.note = studyJpa.getNote();
        this.coment = studyJpa.getComent();
        this.initialDate = studyJpa.getInitialDate();
        this.finishDate = studyJpa.getFinishDate();
    }

    private String idStudent;
    private String idMateria;
    private Float note;
    private String coment;
    private Date initialDate;
    private Date finishDate;
}
