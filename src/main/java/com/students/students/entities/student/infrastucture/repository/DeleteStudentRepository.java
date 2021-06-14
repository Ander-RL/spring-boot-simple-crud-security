package com.students.students.entities.student.infrastucture.repository;


import com.students.students.entities.student.infrastucture.repository.jpa.StudentRepositoryJpa;
import com.students.students.entities.student.infrastucture.repository.port.DeleteStudentPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class DeleteStudentRepository implements DeleteStudentPort {

    StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public void deleteById(String idEstudiante) {

        studentRepositoryJpa.deleteById(idEstudiante);
    }

}
