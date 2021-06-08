package com.students.students.entities.tiporegistro.infrastructure.repository.jpa;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRegistroRepositoryJpa extends JpaRepository<TipoRegistroJpa, String> {
}
