package com.students.students.entities.nota.infrastucture.controller;

import com.students.students.entities.nota.infrastucture.repository.port.DeleteNotaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Nota")
@AllArgsConstructor
@RestController
public class DeleteNotaController {

    private  DeleteNotaPort deleteNotaPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @DeleteMapping("/api/nota/{id}")
    public void deleteById(@PathVariable("id") String idNota){
        deleteNotaPort.deleteById(idNota);
    }
}
