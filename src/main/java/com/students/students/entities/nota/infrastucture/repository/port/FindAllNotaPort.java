package com.students.students.entities.nota.infrastucture.repository.port;


import com.students.students.entities.nota.domain.dto.NotaOutputDto;

import java.util.List;

public interface FindAllNotaPort {
    List<NotaOutputDto> findAll();
}
