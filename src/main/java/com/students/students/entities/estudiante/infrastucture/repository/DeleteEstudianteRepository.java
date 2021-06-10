package com.students.students.entities.estudiante.infrastucture.repository;


import com.students.students.entities.estudiante.infrastucture.repository.jpa.EstudianteRepositoryJpa;
import com.students.students.entities.estudiante.infrastucture.repository.port.DeleteEstudiantePort;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByIdEstudiantesPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;


    @Override
    public void deleteById(String idEstudiante) {

        estudianteRepositoryJpa.deleteById(idEstudiante);
    }

}
