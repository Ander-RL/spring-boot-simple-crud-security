package com.students.students.entities.materia.infrastructure.repository.jpa;

import com.students.students.entities.materia.domain.MateriaJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepositoryJpa extends JpaRepository<MateriaJpa, String> {
}
