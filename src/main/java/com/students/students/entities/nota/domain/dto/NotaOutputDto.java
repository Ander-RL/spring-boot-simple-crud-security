package com.students.students.entities.nota.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaOutputDto {

    public NotaOutputDto(NotaJpa notaJpa){
        this.idNota = notaJpa.getIdNota();
        this.idStudent = notaJpa.getIdStudent();
        this.idMateria = notaJpa.getIdMateria();
        this.idTipoRegistro = notaJpa.getIdTipoRegistro();
        this.note = notaJpa.getNote();
        this.coment = notaJpa.getComent();
        this.branchEnum = notaJpa.getBranchEnum();
        this.creationDate = notaJpa.getCreationDate();
    }

    private String idNota;
    private String idStudent;
    private String idMateria;
    private String idTipoRegistro;
    private Float note;
    private String coment;
    private BranchEnum branchEnum;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date creationDate;
}
