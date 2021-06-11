package com.students.students.entities.nota.infrastucture.controller;


import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.port.CreateNotaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Nota")
@AllArgsConstructor
@RestController
public class CreateNotaController {

    private final CreateNotaPort createNotaPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @PostMapping("/api/nota/")
    public ResponseEntity<NotaOutputDto> create(@RequestBody NotaInputDto notaInputDto){

        NotaOutputDto notaOutputDto = createNotaPort.create(notaInputDto);
        return new ResponseEntity<>(notaOutputDto, HttpStatus.OK);
    }
}
