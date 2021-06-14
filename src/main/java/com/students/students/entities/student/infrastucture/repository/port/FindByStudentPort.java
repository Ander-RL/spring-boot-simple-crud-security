package com.students.students.entities.student.infrastucture.repository.port;


import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.domain.dto.StudentSearchInputDto;

import java.util.List;

public interface FindByStudentPort {
    public List<StudentOutputDto> findBy(StudentSearchInputDto studentSearchInputDto);
}
