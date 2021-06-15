package com.students.students.entities.tiporegistro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoRegistroOutputDto {

    public TipoRegistroOutputDto(TipoRegistroJpa tipoRegistroJpa){
        this.idTipoRegistro = tipoRegistroJpa.getIdTipoRegistro();
        this.name = tipoRegistroJpa.getName();
        this.lastUpdate = tipoRegistroJpa.getLastUpdate();
        this.activo = tipoRegistroJpa.getActivo();
        this.notaList = tipoRegistroJpa.getNotaList();
    }

    private String idTipoRegistro;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date lastUpdate;
    private Boolean activo;
    private List<NotaJpa> notaList;
}
