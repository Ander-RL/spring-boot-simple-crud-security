package com.students.students.entities.estudiante.infrastucture.repository.port;


import com.students.students.entities.estudiante.domain.dto.EstudianteInputDto;

public interface UpdateEstudiantePort {

     void update(String id, EstudianteInputDto estudianteInputDto);
}
