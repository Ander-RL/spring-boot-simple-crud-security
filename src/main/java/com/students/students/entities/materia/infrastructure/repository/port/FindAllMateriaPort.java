package com.students.students.entities.materia.infrastructure.repository.port;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;

import java.util.List;

public interface FindAllMateriaPort {
    List<MateriaOutputDto> findAll();
}
