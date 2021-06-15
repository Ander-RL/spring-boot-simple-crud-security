package com.students.students.entities.study.domain;


import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.study.domain.dto.StudyInputDto;
import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudyJpa {

    public StudyJpa(StudyInputDto studyInputDto){
        this.setIdStudent(studyInputDto.getIdStudent());
        this.setIdMateria(studyInputDto.getIdMateria());
        this.setNote(studyInputDto.getNote());
        this.setComent(studyInputDto.getComent());
        this.setInitialDate(studyInputDto.getInitialDate());
        this.setFinishDate(studyInputDto.getFinishDate());
    }

    public StudyJpa(StudyOutputDto studyOutputDto) {
        this.setIdStudent(studyOutputDto.getIdStudent());
        this.setIdMateria(studyOutputDto.getIdMateria());
        this.setNote(studyOutputDto.getNote());
        this.setComent(studyOutputDto.getComent());
        this.initialDate = studyOutputDto.getInitialDate();
        this.finishDate = studyOutputDto.getFinishDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "study_seq")
    @GenericGenerator(
            name = "study_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_STUDY),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_study")
    private String idStudy;

    @Column(name = "id_student", nullable = false)
    private String idStudent;

    @Column(name = "id_materia", nullable = false)
    private String idMateria;

    @Column(name = "note", nullable = false)
    private Float note;

    @Column(name = "coment")
    private String coment;

    @Column(name = "initial_date", nullable = false)
    private Date initialDate;

    @Column(name = "finish_date", nullable = false)
    private Date finishDate;

    @ManyToOne()
    @JoinColumn(name = "id_student", insertable = false, updatable = false)
    private StudentJpa student;

    @ManyToOne()
    @JoinColumn(name = "id_materia", insertable = false, updatable = false)
    private MateriaJpa materia;

}
