package com.students.students.entities.materia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.study.domain.StudyJpa;
import com.students.students.exception.NullException;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MateriaJpa {

    public MateriaJpa(MateriaInputDto materiaInputDto) {
        this.name = materiaInputDto.getName();
        this.description = materiaInputDto.getDescription();
        this.branch = materiaInputDto.getBranch();
    }

    public MateriaJpa(MateriaOutputDto materiaOutputDto) {
        this.name = materiaOutputDto.getName();
        this.description = materiaOutputDto.getDescription();
        this.branch = materiaOutputDto.getBranch();
        this.notaList = materiaOutputDto.getNotaList();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
    @GenericGenerator(
            name = "materia_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_MATERIA),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_materia")
    private String idMateria;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "branch")
    private BranchEnum branch;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<NotaJpa> notaList = new ArrayList<>();

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyJpa> studyList;
}
