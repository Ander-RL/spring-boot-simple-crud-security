package com.students.students.entities.student.domain;


import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentJpa {

    public StudentJpa(StudentInputDto studentInputDto) {
        setNumHoursWeek(studentInputDto.getNumHoursWeek());
        setComents(studentInputDto.getComents());
        setBranchEnum(studentInputDto.getBranchEnum());
    }

    public StudentJpa(StudentOutputDto studentOutputDto){
        setNumHoursWeek(studentOutputDto.getNumHoursWeek());
        setComents(studentOutputDto.getComents());
        setBranchEnum(studentOutputDto.getBranchEnum());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            name = "estudiantes_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_ESTUDIANTE),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_student")
    String idStudent;

    @Column(name = "id_persona")
    private String idPersona;

    @Column(name = "id_profesor")
    private String idProfesor;

    @Column(name = "num_hours_week", nullable = false)
    Integer numHoursWeek;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch", nullable = false)
    BranchEnum branchEnum;

    @OneToOne
    @JoinColumn (name="fk_persona", referencedColumnName = "id_persona")
    private PersonaJpa persona;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotaJpa> notaList;


}
