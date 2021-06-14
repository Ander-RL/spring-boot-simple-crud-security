package com.students.students.entities.student.infrastucture.repository.port;


import com.students.students.entities.student.domain.dto.StudentInputDto;

public interface UpdateStudentPort {

     void update(String id, StudentInputDto studentInputDto);
}
