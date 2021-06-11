package com.students.students.entities.nota.infrastucture.repository;

import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindAllEstudiantesPort;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.infrastructure.repository.port.FindAllMateriaPort;
import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.nota.domain.dto.NotaInputDto;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.infrastucture.repository.jpa.NotaRepositoryJpa;
import com.students.students.entities.nota.infrastucture.repository.port.CreateNotaPort;
import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.exception.NotFoundException;
import com.students.students.exception.NullException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateNoteRepository implements CreateNotaPort {

    NotaRepositoryJpa repository;
    FindAllEstudiantesPort findAllEstudiantesPort;
    FindAllMateriaPort findAllMateriasPort;

    @Override
    public NotaOutputDto create(NotaInputDto notaInputDto) {

        log.debug("Nota creada -> " + notaInputDto.toString());

        checkNulls(notaInputDto);

        NotaJpa notaJpa = new NotaJpa(notaInputDto);
        repository.save(notaJpa);

        return new NotaOutputDto(notaJpa);
    }


    private void checkNulls(NotaInputDto notaInputDto) {
        if(notaInputDto.getIdStudent() == null)
            throw new NullException("idStudent no puede ser null");
        if(notaInputDto.getIdTipoRegistro() == null)
            throw new NullException("idTipoRegistro no puede ser null");
        if(notaInputDto.getNote() == null)
            throw new NullException("note no puede ser null");
        if(notaInputDto.getBranchEnum() == null)
            throw new NullException("branch no puede ser null");
        if(notaInputDto.getIdMateria() == null)
            throw new NullException("idMateria no puede ser null");
        if(notaInputDto.getComent() == null)
            throw new NullException("coment no puede ser null");
        if(notaInputDto.getCreationDate() == null)
            throw new NullException("creationDate no puede ser null");
    }
}
