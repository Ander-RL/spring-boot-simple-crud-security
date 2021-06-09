package com.students.students.entities.tiporegistro.domain.dto;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoRegistroInputDto {

    public TipoRegistroInputDto(TipoRegistroJpa tipoRegistroJpa){
        this.name = tipoRegistroJpa.getName();
        this.lastUpdate = tipoRegistroJpa.getLastUpdate();
        this.activo = tipoRegistroJpa.getActivo();
    }

    private String name;
    private Date lastUpdate;
    private Boolean activo;
}
