package com.students.students.entities.student.infrastucture.repository;

import com.students.students.entities.student.domain.StudentJpa;
import com.students.students.entities.student.domain.dto.StudentOutputDto;
import com.students.students.entities.student.domain.dto.StudentSearchInputDto;
import com.students.students.entities.student.infrastucture.repository.port.FindByStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindByStudentRepository implements FindByStudentPort {

    EntityManager entityManager;

    @Override
    public List<StudentOutputDto> findBy(StudentSearchInputDto studentSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentJpa> criteriaQuery = criteriaBuilder.createQuery(StudentJpa.class);

        Root<StudentJpa> estudiante = criteriaQuery.from(StudentJpa.class);
        
        Predicate finalPredicate = getPredicate(studentSearchInputDto, criteriaBuilder, estudiante);

        criteriaQuery.where(finalPredicate);

        TypedQuery<StudentJpa> query = entityManager.createQuery(criteriaQuery);

        List<StudentJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new StudentOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(StudentSearchInputDto studentSearchInputDto, CriteriaBuilder criteriaBuilder, Root<StudentJpa> estudiante) {
        Predicate finalPredicate = null;

        if (studentSearchInputDto.getNumHoursWeek() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("numHoursWeek"), studentSearchInputDto.getNumHoursWeek());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studentSearchInputDto.getComents() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("coments"), studentSearchInputDto.getComents());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studentSearchInputDto.getBranchEnum() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("branch"), studentSearchInputDto.getBranchEnum());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
