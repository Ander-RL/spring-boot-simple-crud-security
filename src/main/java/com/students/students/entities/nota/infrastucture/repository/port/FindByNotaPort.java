package com.students.students.entities.nota.infrastucture.repository.port;


import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.domain.dto.NotaSearchInputDto;

import java.util.List;

public interface FindByNotaPort {
    List<NotaOutputDto> findBy(NotaSearchInputDto notaSearchInputDto);
}
