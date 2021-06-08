package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.CreateTipoRegistroPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateTipoRegistroRepository implements CreateTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;

    @Override
    public TipoRegistroOutputDto create(TipoRegistroInputDto tipoRegistroInputDto) {
        log.debug("TipoRegistro creado -> " + tipoRegistroInputDto.toString());

        TipoRegistroJpa tipoRegistroJpa = new TipoRegistroJpa(tipoRegistroInputDto);

        repository.save(tipoRegistroJpa);
        return new TipoRegistroOutputDto(tipoRegistroJpa);
    }
}
