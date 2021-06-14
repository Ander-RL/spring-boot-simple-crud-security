package com.students.students.entities.student.infrastucture.repository;


import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.jpa.StudentRepositoryJpa;
import com.students.students.entities.student.infrastucture.repository.port.FindAllStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllStudentRepository implements FindAllStudentPort {

    StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public List<StudentOutputDto> findAll() {

        List<StudentOutputDto> listOut = new ArrayList<StudentOutputDto>();
        List<StudentJpa> listIn = studentRepositoryJpa.findAll();

        for(StudentJpa studentJpa : listIn) {
            listOut.add(new StudentOutputDto(studentJpa));
        }
        return listOut;
    }
}
