package com.students.students.entities.nota.infrastucture.repository.port;


import com.students.students.entities.nota.domain.dto.NotaInputDto;

public interface UpdateNotaPort {
    void update(String idNota, NotaInputDto notaInputDto);
}
