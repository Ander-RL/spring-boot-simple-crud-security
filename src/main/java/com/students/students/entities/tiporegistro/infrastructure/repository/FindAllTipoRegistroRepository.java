package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindAllTipoRegistroPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllTipoRegistroRepository implements FindAllTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;

    @Override
    public List<TipoRegistroOutputDto> findAll() {

        List<TipoRegistroOutputDto> listOut = new ArrayList<>();
        List<TipoRegistroJpa> listIn = repository.findAll();

        for(TipoRegistroJpa tipoRegistro : listIn) {
            listOut.add(new TipoRegistroOutputDto(tipoRegistro));
        }
        return listOut;
    }
}
