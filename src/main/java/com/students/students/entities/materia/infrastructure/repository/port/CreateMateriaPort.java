package com.students.students.entities.materia.infrastructure.repository.port;

import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;

public interface CreateMateriaPort {
    MateriaOutputDto create(MateriaInputDto materiaInputDto);
}
