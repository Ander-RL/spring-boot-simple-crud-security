package com.students.students.entities.student.infrastucture.repository.port;



import com.students.students.entities.student.domain.dto.StudentOutputDto;

import java.util.List;

public interface FindAllStudentPort {
    List<StudentOutputDto> findAll();
}
