package com.students.students.entities.estudiante.infrastucture.repository;

import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.jpa.EstudianteRepositoryJpa;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByIdEstudiantesPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdEstudiantesRepository implements FindByIdEstudiantesPort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public EstudianteOutputDto findById(String id) throws NotFoundException {
        return new EstudianteOutputDto(estudianteRepositoryJpa.findById(id).orElseThrow(() -> new NotFoundException("No se pudo encontrar al estudiante con Id = "+ id)));
    }
}
