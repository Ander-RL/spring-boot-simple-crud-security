package com.students.students.entities.estudiante.infrastucture.repository;


import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.jpa.EstudianteRepositoryJpa;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindAllEstudiantesPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllEstudiantesRepository implements FindAllEstudiantesPort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public List<EstudianteOutputDto> findAll() {

        List<EstudianteOutputDto> listOut = new ArrayList<EstudianteOutputDto>();
        List<EstudianteJpa> listIn = estudianteRepositoryJpa.findAll();

        for(EstudianteJpa estudianteJpa : listIn) {
            listOut.add(new EstudianteOutputDto(estudianteJpa));
        }
        return listOut;
    }
}
