package com.students.students.entities.nota.infrastucture.repository;

import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.jpa.NotaRepositoryJpa;
import com.students.students.entities.nota.infrastucture.repository.port.FindAllNotaPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class FindAllNotaRepository implements FindAllNotaPort {

    NotaRepositoryJpa repository;

    @Override
    public List<NotaOutputDto> findAll() {

        List<NotaOutputDto> listOut = new ArrayList<>();
        List<NotaJpa> listIn = repository.findAll();

        for(NotaJpa notaJpa : listIn) {
            listOut.add(new NotaOutputDto(notaJpa));
        }
        return listOut;
    }
}
