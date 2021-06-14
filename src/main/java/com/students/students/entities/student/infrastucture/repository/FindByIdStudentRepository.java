package com.students.students.entities.student.infrastucture.repository;

import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.jpa.StudentRepositoryJpa;
import com.students.students.entities.student.infrastucture.repository.port.FindByIdStudentPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdStudentRepository implements FindByIdStudentPort {

    StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public StudentOutputDto findById(String id) throws NotFoundException {
        return new StudentOutputDto(studentRepositoryJpa.findById(id).orElseThrow(() -> new NotFoundException("No se pudo encontrar al estudiante con Id = "+ id)));
    }
}
