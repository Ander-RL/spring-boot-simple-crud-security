package com.students.students.entities.nota.infrastucture.repository.jpa;

import com.students.students.entities.nota.domain.NotaJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepositoryJpa extends JpaRepository<NotaJpa, String> {
}
