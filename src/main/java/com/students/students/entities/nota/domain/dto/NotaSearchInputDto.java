package com.students.students.entities.nota.domain.dto;


import com.students.students.entities.nodatabase.BranchEnum;
import lombok.Data;

import java.util.Date;

@Data
public class NotaSearchInputDto {

    private String idStudent;
    private String idMateria;
    private String idTipoRegistro;
    private Float note;
    private String coment;
    private BranchEnum branchEnum;
    private Date creationDate;
}
