package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.CreateMateriaPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateMateriaRepository implements CreateMateriaPort {

    MateriaRepositoryJpa repository;

    @Override
    public MateriaOutputDto create(MateriaInputDto materiaInputDto) {
        log.debug("TipoRegistro creado -> " + materiaInputDto.toString());

        MateriaJpa materiaJpa = new MateriaJpa(materiaInputDto);

        repository.save(materiaJpa);
        return new MateriaOutputDto(materiaJpa);
    }
}
