package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.CreateMateriaPort;
import com.students.students.exception.NullException;
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
        log.debug("Materia creada -> " + materiaInputDto.toString());

        MateriaJpa materiaJpa = new MateriaJpa(materiaInputDto);

        repository.save(materiaJpa);
        return new MateriaOutputDto(materiaJpa);
    }
    private void checkNulls(MateriaInputDto materiaInputDto){
        if(materiaInputDto.getBranch() == null)
            throw new NullException("Branch no puede ser null");
    }
}
