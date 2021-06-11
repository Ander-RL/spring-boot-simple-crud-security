package com.students.students.entities.nota.infrastucture.repository;


import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.jpa.NotaRepositoryJpa;
import com.students.students.entities.nota.infrastucture.repository.port.FindByIdNotaPort;
import com.students.students.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdNotaRepository implements FindByIdNotaPort {

    NotaRepositoryJpa repository;

    @Override
    public NotaOutputDto findById(String idNota) {
        return new NotaOutputDto(repository.findById(idNota).orElseThrow(() -> new NotFoundException("No se pudo encontrar la nota con Id = "+ idNota)));
    }
}
