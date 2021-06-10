package com.students.students.entities.estudiante.infrastucture.repository;


import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.jpa.EstudianteRepositoryJpa;
import com.students.students.entities.estudiante.infrastucture.repository.port.CreateEstudiantePort;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.exception.InvalidValueException;
import com.students.students.exception.NullException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateEstudianteRepository implements CreateEstudiantePort {

    private final EstudianteRepositoryJpa repository;

    @Override
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto) {
        log.debug("Usuario creado -> " + estudianteInputDto.toString());
        checkNulls(estudianteInputDto);

        EstudianteJpa estudianteJpa = new EstudianteJpa(estudianteInputDto);

        repository.save(estudianteJpa);
        return new EstudianteOutputDto(estudianteJpa);
    }

    private void checkNulls(EstudianteInputDto estudianteInputDto) {
        if (estudianteInputDto.getBranchEnum() == null)
            throw new NullException("branch no puede ser null");
        if (estudianteInputDto.getNumHoursWeek() == null)
            throw new NullException("NumHoursWeek no puede ser null");
    }
}
