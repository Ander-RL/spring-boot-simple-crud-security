package com.students.students.entities.materia.domain.dto;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MateriaInputDto {

    public MateriaInputDto(MateriaJpa materiaJpa){
        this.name = materiaJpa.getName();
        this.description = materiaJpa.getDescription();
        this.branch = materiaJpa.getBranch();
    }

    private String name;
    private String description;
    private BranchEnum branch;
}
