package com.students.students.entities.study.infrastucture.repository.jpa;


import com.students.students.entities.study.domain.StudyJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepositoryJpa extends JpaRepository<StudyJpa, String> {
}
