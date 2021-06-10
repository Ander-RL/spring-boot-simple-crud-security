package com.students.students.entities.estudiante.domain;


import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteJpa {

    public EstudianteJpa(EstudianteInputDto estudianteInputDto) {
        setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        setComents(estudianteInputDto.getComents());
        setBranchEnum(estudianteInputDto.getBranchEnum());
    }

    public EstudianteJpa(EstudianteOutputDto estudianteOutputDto){
        setNumHoursWeek(estudianteOutputDto.getNumHoursWeek());
        setComents(estudianteOutputDto.getComents());
        setBranchEnum(estudianteOutputDto.getBranchEnum());
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
}
