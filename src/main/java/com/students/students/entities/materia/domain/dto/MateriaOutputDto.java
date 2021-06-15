package com.students.students.entities.materia.domain.dto;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import com.students.students.entities.nota.domain.NotaJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MateriaOutputDto {

    public MateriaOutputDto(MateriaJpa materiaJpa){
        this.idMateria=materiaJpa.getIdMateria();
        this.name = materiaJpa.getName();
        this.description = materiaJpa.getDescription();
        this.branch = materiaJpa.getBranch();
        this.notaList = materiaJpa.getNotaList();
    }
    private String idMateria;
    private String name;
    private String description;
    private BranchEnum branch;
    private List<NotaJpa> notaList;
}
