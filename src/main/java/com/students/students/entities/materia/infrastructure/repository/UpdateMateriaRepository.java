package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.materia.domain.dto.MateriaInputDto;
import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.FindByIdMateriaPort;
import com.students.students.entities.materia.infrastructure.repository.port.UpdateMateriaPort;
import com.students.students.exception.InvalidDateException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@AllArgsConstructor
@Repository
public class UpdateMateriaRepository implements UpdateMateriaPort {

    MateriaRepositoryJpa repository;
    FindByIdMateriaPort findByIdMateriaPort;

    @Override
    public void update(String idMateria, MateriaInputDto materiaInputDto) {
        log.debug("editando Materia " + idMateria);
        MateriaJpa materiaJpa = new MateriaJpa(findByIdMateriaPort.findById(idMateria));

        repository.save(updatedMateria(materiaJpa, materiaInputDto, idMateria));
    }

    private MateriaJpa updatedMateria(MateriaJpa materiaJpa, MateriaInputDto materiaInputDto, String idmateria) {


        if (materiaInputDto.getName() != null)
            materiaJpa.setName(materiaInputDto.getName());

        if (materiaInputDto.getDescription() != null)
            materiaJpa.setDescription(materiaInputDto.getDescription());

        if (materiaInputDto.getBranch() != null)
            materiaJpa.setBranch(materiaInputDto.getBranch());

        materiaJpa.setIdMateria(idmateria);

        return materiaJpa;
    }
}
