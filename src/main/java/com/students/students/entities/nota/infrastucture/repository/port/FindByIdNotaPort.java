package com.students.students.entities.nota.infrastucture.repository.port;


import com.students.students.entities.nota.domain.dto.NotaOutputDto;

public interface FindByIdNotaPort {
    NotaOutputDto findById(String idNota);
}
