package com.students.students.entities.materia.infrastructure.controller;

import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.domain.dto.MateriaSearchInputDto;
import com.students.students.entities.materia.infrastructure.repository.port.FindByMateriaPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Materia")
@AllArgsConstructor
@RestController
public class FindByMateriaController {

    FindByMateriaPort findByMateriaPort;

    @PostMapping("/api/materia/findby")
    List<MateriaOutputDto> findBy(@RequestBody MateriaSearchInputDto materiaSearchInputDto){
        if(findByMateriaPort.findBy(materiaSearchInputDto).isEmpty()) {
            throw new NotFoundException();
        }
        return findByMateriaPort.findBy(materiaSearchInputDto);
    }
}
