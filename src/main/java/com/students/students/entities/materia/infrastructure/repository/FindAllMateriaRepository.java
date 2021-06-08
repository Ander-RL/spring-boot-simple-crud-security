package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.jpa.MateriaRepositoryJpa;
import com.students.students.entities.materia.infrastructure.repository.port.FindAllMateriaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllMateriaRepository implements FindAllMateriaPort {

    MateriaRepositoryJpa repository;

    @Override
    public List<MateriaOutputDto> findAll() {

        List<MateriaOutputDto> listOut = new ArrayList<>();
        List<MateriaJpa> listIn = repository.findAll();

        for(MateriaJpa tipoRegistro : listIn) {
            listOut.add(new MateriaOutputDto(tipoRegistro));
        }
        return listOut;
    }
}
