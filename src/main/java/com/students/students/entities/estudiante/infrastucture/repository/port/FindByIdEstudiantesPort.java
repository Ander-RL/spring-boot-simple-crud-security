package com.students.students.entities.estudiante.infrastucture.repository.port;



import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.exception.NotFoundException;

public interface FindByIdEstudiantesPort {
   EstudianteOutputDto findById(String id) throws NotFoundException;
}
