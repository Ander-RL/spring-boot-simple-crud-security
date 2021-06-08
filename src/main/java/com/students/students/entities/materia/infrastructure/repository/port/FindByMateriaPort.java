package com.students.students.entities.materia.infrastructure.repository.port;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.domain.dto.MateriaSearchInputDto;

import java.util.List;

public interface FindByMateriaPort {
    List<MateriaOutputDto> findBy(MateriaSearchInputDto materiaSearchInputDto);
}
