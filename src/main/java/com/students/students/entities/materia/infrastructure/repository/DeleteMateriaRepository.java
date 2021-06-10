package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.DeleteMateriaPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeleteMateriaRepository implements DeleteMateriaPort {

    MateriaRepositoryJpa repository;

    @Override
    public void deleteById(String idMateria) {
        repository.delete(repository.findById(idMateria).orElseThrow(() -> new NotFoundException("No se encontro Materia con id -> " + idMateria)));
    }
}
