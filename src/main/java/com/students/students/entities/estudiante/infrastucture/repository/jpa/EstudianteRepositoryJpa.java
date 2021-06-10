package com.students.students.entities.estudiante.infrastucture.repository.jpa;



import com.students.students.entities.estudiante.domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositoryJpa extends JpaRepository<EstudianteJpa, String> {
}
