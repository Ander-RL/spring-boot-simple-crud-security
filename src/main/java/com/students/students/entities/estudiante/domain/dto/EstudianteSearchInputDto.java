package com.students.students.entities.estudiante.domain.dto;



import com.students.students.entities.nodatabase.BranchEnum;
import lombok.Data;

@Data
public class EstudianteSearchInputDto {

    private Integer numHoursWeek;
    private String coments;
    private BranchEnum branchEnum;
}
