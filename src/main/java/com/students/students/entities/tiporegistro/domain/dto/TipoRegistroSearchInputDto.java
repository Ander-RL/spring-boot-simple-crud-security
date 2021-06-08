package com.students.students.entities.tiporegistro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TipoRegistroSearchInputDto {

    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date lastUpdate;
    private Boolean activo;
}
