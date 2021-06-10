package com.students.students.entities.estudiante.infrastucture.repository.port;


import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteSearchInputDto;

import java.util.List;

public interface FindByEstudiantePort {
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto);
}
