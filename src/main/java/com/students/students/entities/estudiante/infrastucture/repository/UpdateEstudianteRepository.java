package com.students.students.entities.estudiante.infrastucture.repository;


import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.infrastucture.repository.jpa.EstudianteRepositoryJpa;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByIdEstudiantesPort;
import com.students.students.entities.estudiante.infrastucture.repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {

    private final FindByIdEstudiantesPort findByIdEstudiantesPort;
    private final EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public void update(String id, EstudianteInputDto estudianteInputDto){
        log.debug("editando estudiante " + id);
        checkUpdateable(id);
        EstudianteJpa estudianteJpa = new EstudianteJpa(findByIdEstudiantesPort.findById(id));
        estudianteRepositoryJpa.save(updatedEstudiante(estudianteJpa, estudianteInputDto, id));
    }

    private void checkUpdateable(String estudianteId){
        findByIdEstudiantesPort.findById(estudianteId);
        log.debug("estudiante editar existe");

    }

    private EstudianteJpa updatedEstudiante(EstudianteJpa estudianteJpa, EstudianteInputDto estudianteInputDto, String id) {

        if(estudianteInputDto.getNumHoursWeek() != null)
            estudianteJpa.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());

        if(estudianteInputDto.getBranchEnum() != null)
            estudianteJpa.setBranchEnum(estudianteInputDto.getBranchEnum());

        if(estudianteInputDto.getComents() != null)
            estudianteJpa.setComents(estudianteInputDto.getComents());

        estudianteJpa.setIdStudent(id);

        return estudianteJpa;
    }
}
