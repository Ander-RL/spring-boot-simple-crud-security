package com.students.students.entities.tiporegistro.domain.dto;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoRegistroInputDto {

    public TipoRegistroInputDto(TipoRegistroJpa tipoRegistroJpa){
        this.name = tipoRegistroJpa.getName();
        this.lastUpdate = tipoRegistroJpa.getLastUpdate().toString();
        this.activo = tipoRegistroJpa.getActivo();
    }

    private String name;
    private String lastUpdate;
    private Boolean activo;
}
