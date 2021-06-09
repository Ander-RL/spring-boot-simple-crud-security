package com.students.students.entities.tiporegistro.domain;

import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.exception.InvalidDateException;
import com.students.students.exception.NullException;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoRegistroJpa {

    public TipoRegistroJpa(TipoRegistroInputDto tipoRegistroInputDto) {
        setName(tipoRegistroInputDto.getName());
        setLastUpdate(tipoRegistroInputDto.getLastUpdate());
        this.activo = tipoRegistroInputDto.getActivo();
    }

    public TipoRegistroJpa(TipoRegistroOutputDto tipoRegistroOutputDto) {
        this.name = tipoRegistroOutputDto.getName();
        this.lastUpdate = tipoRegistroOutputDto.getLastUpdate();
        this.activo = tipoRegistroOutputDto.getActivo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_registro_seq")
    @GenericGenerator(
            name = "tipo_registro_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_TIPOREGISTRO),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_tipo_registro")
    private String idTipoRegistro;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Date lastUpdate;

    @Column(name = "activo")
    private Boolean activo;
}
