package com.students.students.entities.materia.domain.dto;

import com.students.students.entities.nodatabase.BranchEnum;
import lombok.Data;


import java.util.Date;

@Data
public class MateriaSearchInputDto {

    private String name;
    private Date description;
    private BranchEnum branch;
}
