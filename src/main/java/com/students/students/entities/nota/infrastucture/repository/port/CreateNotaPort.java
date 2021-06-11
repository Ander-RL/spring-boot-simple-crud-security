package com.students.students.entities.nota.infrastucture.repository.port;


import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;

public interface CreateNotaPort {
    NotaOutputDto create(NotaInputDto notaInputDto);
}
