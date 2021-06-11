package com.students.students.entities.nota.domain.dto;


import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.NotaJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaInputDto {

    public NotaInputDto(NotaJpa notaJpa) {
        this.idStudent = notaJpa.getIdStudent();
        this.idMateria = notaJpa.getIdMateria();
        this.idTipoRegistro = notaJpa.getIdTipoRegistro();
        this.note = notaJpa.getNote();
        this.coment = notaJpa.getComent();
        this.branchEnum = notaJpa.getBranchEnum();
        this.creationDate = notaJpa.getCreationDate();
    }

    private String idStudent;
    private String idMateria;
    private String idTipoRegistro;
    private Float note;
    private String coment;
    private BranchEnum branchEnum;
    private Date creationDate;
}
