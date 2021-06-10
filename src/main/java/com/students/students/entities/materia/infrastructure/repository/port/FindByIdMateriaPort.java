package com.students.students.entities.materia.infrastructure.repository.port;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;

public interface FindByIdMateriaPort {
    MateriaOutputDto findById(String idMateria);
}
