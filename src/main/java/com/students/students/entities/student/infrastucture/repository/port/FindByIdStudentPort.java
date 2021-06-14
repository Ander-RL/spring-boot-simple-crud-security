package com.students.students.entities.student.infrastucture.repository.port;



import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.exception.NotFoundException;

public interface FindByIdStudentPort {
   StudentOutputDto findById(String id) throws NotFoundException;
}
