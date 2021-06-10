package com.students.students.entities.study.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StudySearchInputDto {

    private String idStudent;
    private String idMateria;
    private Float note;
    private String coment;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date initialDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date finishDate;
}
