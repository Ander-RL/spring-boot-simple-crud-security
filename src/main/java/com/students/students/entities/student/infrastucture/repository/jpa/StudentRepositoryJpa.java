package com.students.students.entities.student.infrastucture.repository.jpa;



import com.students.students.entities.student.domain.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, String> {
}
