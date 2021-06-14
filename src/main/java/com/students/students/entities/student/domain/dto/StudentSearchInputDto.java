package com.students.students.entities.student.domain.dto;



import com.students.students.entities.nodatabase.BranchEnum;
import lombok.Data;

@Data
public class StudentSearchInputDto {

    private Integer numHoursWeek;
    private String coments;
    private BranchEnum branchEnum;
}
