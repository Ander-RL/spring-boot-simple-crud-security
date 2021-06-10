package com.students.students.entities.estudiante.infrastucture.repository;

import com.students.students.entities.estudiante.domain.EstudianteJpa;
import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.domain.dto.EstudianteSearchInputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByEstudiantePort;
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
public class FindByEstudianteRepository implements FindByEstudiantePort {

    EntityManager entityManager;

    @Override
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> criteriaQuery = criteriaBuilder.createQuery(EstudianteJpa.class);

        Root<EstudianteJpa> estudiante = criteriaQuery.from(EstudianteJpa.class);
        
        Predicate finalPredicate = getPredicate(estudianteSearchInputDto, criteriaBuilder, estudiante);

        criteriaQuery.where(finalPredicate);

        TypedQuery<EstudianteJpa> query = entityManager.createQuery(criteriaQuery);

        List<EstudianteJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new EstudianteOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(EstudianteSearchInputDto estudianteSearchInputDto, CriteriaBuilder criteriaBuilder, Root<EstudianteJpa> estudiante) {
        Predicate finalPredicate = null;

        if (estudianteSearchInputDto.getNumHoursWeek() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("numHoursWeek"), estudianteSearchInputDto.getNumHoursWeek());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getComents() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("coments"), estudianteSearchInputDto.getComents());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getBranchEnum() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("branch"), estudianteSearchInputDto.getBranchEnum());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
