package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.FindByIdMateriaPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdMateriaRepository implements FindByIdMateriaPort {

    MateriaRepositoryJpa repository;

    @Override
    public MateriaOutputDto findById(String idMateria) {
        return new MateriaOutputDto(repository.findById(idMateria).orElseThrow(() -> new NotFoundException("No se encontro Materia con id -> " + idMateria)));
    }
}
