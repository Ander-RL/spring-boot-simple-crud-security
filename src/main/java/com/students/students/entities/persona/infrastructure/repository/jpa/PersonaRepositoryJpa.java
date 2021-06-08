package com.students.students.entities.persona.infrastructure.repository.jpa;

import com.students.students.entities.persona.domain.PersonaJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositoryJpa extends JpaRepository<PersonaJpa, String> {
}
