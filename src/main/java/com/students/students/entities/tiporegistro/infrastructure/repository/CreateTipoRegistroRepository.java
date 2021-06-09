package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.CreateTipoRegistroPort;
import com.students.students.exception.InvalidDateException;
import com.students.students.exception.NullException;
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
public class CreateTipoRegistroRepository implements CreateTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;

    @Override
    public TipoRegistroOutputDto create(TipoRegistroInputDto tipoRegistroInputDto) {
        log.debug("TipoRegistro creado -> " + tipoRegistroInputDto.toString());

        checkNulls(tipoRegistroInputDto);

        TipoRegistroJpa tipoRegistroJpa = new TipoRegistroJpa(tipoRegistroInputDto);

        repository.save(tipoRegistroJpa);
        return new TipoRegistroOutputDto(tipoRegistroJpa);
    }

    private void checkNulls(TipoRegistroInputDto tipoRegistroInputDto) {
        if (tipoRegistroInputDto.getName() == null) throw new NullException("Name no puede ser null");
        if (tipoRegistroInputDto.getLastUpdate() == null) throw new NullException("LastUpdate no puede ser null");
    }
}
