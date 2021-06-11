package com.students.students.entities.nota.domain;



import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaJpa {

    public NotaJpa(NotaInputDto notaInputDto) {
        setIdStudent(notaInputDto.getIdStudent());
        setIdMateria(notaInputDto.getIdMateria());
        setIdTipoRegistro(notaInputDto.getIdTipoRegistro());
        setNote(notaInputDto.getNote());
        setComent(notaInputDto.getComent());
        setBranchEnum(notaInputDto.getBranchEnum());
        setCreationDate(notaInputDto.getCreationDate());
    }

    public NotaJpa(NotaOutputDto notaOutputDto) {
        setIdStudent(notaOutputDto.getIdStudent());
        setIdMateria(notaOutputDto.getIdMateria());
        setIdTipoRegistro(notaOutputDto.getIdTipoRegistro());
        setNote(notaOutputDto.getNote());
        setComent(notaOutputDto.getComent());
        setBranchEnum(notaOutputDto.getBranchEnum());
        setCreationDate(notaOutputDto.getCreationDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_seq")
    @GenericGenerator(
            name = "nota_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_NOTA),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_nota")
    private String idNota;

    @Column(name = "id_student", nullable = false)
    private String idStudent;

    @Column(name = "id_materia", nullable = false)
    private String idMateria;

    @Column(name = "id_tipo_registro")
    private String idTipoRegistro;

    @Column(name = "note", nullable = false)
    private Float note;

    @Column(name = "coment")
    private String coment;

    @Column(name = "branch", nullable = false)
    private BranchEnum branchEnum;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name = "fk_student")
    private EstudianteJpa estudiante;

    @ManyToOne()
    @JoinColumn(name = "fk_materia")
    private MateriaJpa materia;

    @ManyToOne()
    @JoinColumn(name = "fk_tipo_registro")
    private TipoRegistroJpa tipoRegistro;

}
