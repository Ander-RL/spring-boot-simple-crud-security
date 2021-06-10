package com.students.students.entities.estudiante.domain.dto;



import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteInputDto {

    public EstudianteInputDto(EstudianteJpa estudianteJpa){
        this.numHoursWeek = estudianteJpa.getNumHoursWeek();
        this.coments = estudianteJpa.getComents();
        this.branchEnum = estudianteJpa.getBranchEnum();
    }
    private Integer numHoursWeek;
    private String coments;
    private BranchEnum branchEnum;
}
