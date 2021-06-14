package com.students.students.entities.student.infrastucture.repository.port;



import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.domain.dto.StudentOutputDto;

public interface CreateStudentPort {
    public StudentOutputDto create(StudentInputDto studentInputDto);
}
