package com.students.students.entities.materia.infrastructure.repository.port;


import com.students.students.entities.materia.domain.dto.MateriaInputDto;

public interface UpdateMateriaPort {
    void update(String idMateria, MateriaInputDto materiaInputDto);
}
