package com.students.students.entities.student.domain.dto;



import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.nodatabase.BranchEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentOutputDto {

    public StudentOutputDto(StudentJpa studentJpa){
        this.Id = studentJpa.getIdStudent();
        this.numHoursWeek = studentJpa.getNumHoursWeek();
        this.coments = studentJpa.getComents();
        this.branchEnum = studentJpa.getBranchEnum();
        this.notaList = studentJpa.getNotaList();
    }
    private String Id;
    private Integer numHoursWeek;
    private String coments;
    private BranchEnum branchEnum;
    private List<NotaJpa> notaList;
}
