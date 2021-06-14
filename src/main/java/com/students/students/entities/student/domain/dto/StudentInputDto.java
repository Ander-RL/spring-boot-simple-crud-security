package com.students.students.entities.student.domain.dto;



import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentInputDto {

    public StudentInputDto(StudentJpa studentJpa){
        this.numHoursWeek = studentJpa.getNumHoursWeek();
        this.coments = studentJpa.getComents();
        this.branchEnum = studentJpa.getBranchEnum();
    }
    private Integer numHoursWeek;
    private String coments;
    private BranchEnum branchEnum;
}
