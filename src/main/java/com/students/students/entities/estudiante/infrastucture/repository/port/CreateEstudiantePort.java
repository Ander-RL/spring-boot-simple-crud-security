package com.students.students.entities.estudiante.infrastucture.repository.port;



import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;

public interface CreateEstudiantePort {
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto);
}
