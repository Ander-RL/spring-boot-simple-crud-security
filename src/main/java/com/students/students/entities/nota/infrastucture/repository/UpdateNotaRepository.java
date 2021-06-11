package com.students.students.entities.nota.infrastucture.repository;

import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.infrastucture.repository.jpa.NotaRepositoryJpa;
import com.students.students.entities.nota.infrastucture.repository.port.FindByIdNotaPort;
import com.students.students.entities.nota.infrastucture.repository.port.UpdateNotaPort;
import com.students.students.exception.InvalidDateException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@Repository
@AllArgsConstructor
public class UpdateNotaRepository implements UpdateNotaPort {

    private final FindByIdNotaPort findByIdNotaPort;
    private final NotaRepositoryJpa repository;

    @Override
    public void update(String idNota, NotaInputDto notaInputDto) {
        log.debug("editando nota " + idNota);

        NotaJpa notaJpa = new NotaJpa(findByIdNotaPort.findById(idNota));

        repository.save(updatedNota(notaJpa, notaInputDto, idNota));
    }

    private NotaJpa updatedNota(NotaJpa notaJpa, NotaInputDto notaInputDto, String idNota) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = notaInputDto.getCreationDate();
        } catch (Exception e) {
            throw new InvalidDateException();
        }

        if(notaInputDto.getIdStudent() != null)
            notaJpa.setIdStudent(notaInputDto.getIdStudent());

        if(notaInputDto.getIdMateria() != null)
            notaJpa.setIdMateria(notaInputDto.getIdMateria());

        if(notaInputDto.getIdTipoRegistro() != null)
            notaJpa.setIdTipoRegistro(notaInputDto.getIdTipoRegistro());

        if(notaInputDto.getNote() != null)
            notaJpa.setNote(notaInputDto.getNote());

        if(notaInputDto.getComent() != null)
            notaJpa.setComent(notaInputDto.getComent());

        if(notaInputDto.getBranchEnum() != null)
            notaJpa.setBranchEnum(notaInputDto.getBranchEnum());

        if(notaInputDto.getCreationDate() != null )
            notaJpa.setCreationDate(date);

        notaJpa.setIdNota(idNota);

        return notaJpa;
    }
}
