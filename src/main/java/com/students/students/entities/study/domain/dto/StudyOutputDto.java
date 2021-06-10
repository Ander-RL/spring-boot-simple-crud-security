package com.students.students.entities.study.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.students.students.entities.study.domain.StudyJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudyOutputDto {

    public StudyOutputDto(StudyJpa studyJpa) {
        this.idStudy = studyJpa.getIdStudy();
        this.idStudent = studyJpa.getIdStudent();
        this.idMateria = studyJpa.getIdMateria();
        this.note = studyJpa.getNote();
        this.coment = studyJpa.getComent();
        this.initialDate = studyJpa.getInitialDate();
        this.finishDate = studyJpa.getFinishDate();
    }

    private String idStudy;
    private String idStudent;
    private String idMateria;
    private Float note;
    private String coment;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date initialDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date finishDate;
}
