package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.jpa.TipoRegistroRepositoryJpa;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByIdTipoRegistroPort;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.UpdateTipoRegistroPort;
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
public class UpdateTipoRegistroRepository implements UpdateTipoRegistroPort {

    TipoRegistroRepositoryJpa repository;
    FindByIdTipoRegistroPort findByIdTipoRegistroPort;

    @Override
    public void update(String idTipoRegistro, TipoRegistroInputDto tipoRegistroInputDto) {
        log.debug("editando TipoRegistro " + idTipoRegistro);
        TipoRegistroJpa tipoRegistroJpa = new TipoRegistroJpa(findByIdTipoRegistroPort.findById(idTipoRegistro));

        repository.save(updatedTipoRegistro(tipoRegistroJpa, tipoRegistroInputDto, idTipoRegistro));
    }

    private TipoRegistroJpa updatedTipoRegistro(TipoRegistroJpa tipoRegistroJpa, TipoRegistroInputDto tipoRegistroInputDto, String idTipoRegistro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = dateFormat.parse(tipoRegistroInputDto.getLastUpdate());
        } catch (Exception e) {
            throw new InvalidDateException();
        }

        if (tipoRegistroInputDto.getName() != null)
            tipoRegistroJpa.setName(tipoRegistroInputDto.getName());

        if (tipoRegistroInputDto.getLastUpdate() != null)
            tipoRegistroJpa.setLastUpdate(date);

        if (tipoRegistroInputDto.getActivo() != null)
            tipoRegistroJpa.setActivo(tipoRegistroInputDto.getActivo());

        tipoRegistroJpa.setIdTipoRegistro(idTipoRegistro);

        return tipoRegistroJpa;
    }
}
