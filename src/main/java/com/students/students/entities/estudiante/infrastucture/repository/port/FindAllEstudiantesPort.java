package com.students.students.entities.estudiante.infrastucture.repository.port;



import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;

import java.util.List;

public interface FindAllEstudiantesPort {
    List<EstudianteOutputDto> findAll();
}
