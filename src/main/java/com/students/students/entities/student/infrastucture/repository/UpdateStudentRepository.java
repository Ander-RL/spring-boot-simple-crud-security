package com.students.students.entities.student.infrastucture.repository;


import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.student.domain.dto.StudentInputDto;
import com.students.students.entities.student.infrastucture.repository.jpa.StudentRepositoryJpa;
import com.students.students.entities.student.infrastucture.repository.port.FindByIdStudentPort;
import com.students.students.entities.student.infrastucture.repository.port.UpdateStudentPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class UpdateStudentRepository implements UpdateStudentPort {

    private final FindByIdStudentPort findByIdStudentPort;
    private final StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public void update(String id, StudentInputDto studentInputDto){
        log.debug("editando estudiante " + id);
        checkUpdateable(id);
        StudentJpa studentJpa = new StudentJpa(findByIdStudentPort.findById(id));
        studentRepositoryJpa.save(updatedEstudiante(studentJpa, studentInputDto, id));
    }

    private void checkUpdateable(String estudianteId){
        findByIdStudentPort.findById(estudianteId);
        log.debug("estudiante editar existe");

    }

    private StudentJpa updatedEstudiante(StudentJpa studentJpa, StudentInputDto studentInputDto, String id) {

        if(studentInputDto.getNumHoursWeek() != null)
            studentJpa.setNumHoursWeek(studentInputDto.getNumHoursWeek());

        if(studentInputDto.getBranchEnum() != null)
            studentJpa.setBranchEnum(studentInputDto.getBranchEnum());

        if(studentInputDto.getComents() != null)
            studentJpa.setComents(studentInputDto.getComents());

        studentJpa.setIdStudent(id);

        return studentJpa;
    }
}
