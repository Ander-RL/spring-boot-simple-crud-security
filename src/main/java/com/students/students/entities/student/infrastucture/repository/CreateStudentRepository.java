package com.students.students.entities.student.infrastucture.repository;


import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.infrastucture.repository.jpa.StudentRepositoryJpa;
import com.students.students.entities.student.infrastucture.repository.port.CreateStudentPort;
import com.students.students.exception.NullException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateStudentRepository implements CreateStudentPort {

    private final StudentRepositoryJpa repository;

    @Override
    public StudentOutputDto create(StudentInputDto studentInputDto) {
        log.debug("Usuario creado -> " + studentInputDto.toString());
        checkNulls(studentInputDto);

        StudentJpa studentJpa = new StudentJpa(studentInputDto);

        repository.save(studentJpa);
        return new StudentOutputDto(studentJpa);
    }

    private void checkNulls(StudentInputDto studentInputDto) {
        if (studentInputDto.getBranchEnum() == null)
            throw new NullException("branch no puede ser null");
        if (studentInputDto.getNumHoursWeek() == null)
            throw new NullException("NumHoursWeek no puede ser null");
    }
}
