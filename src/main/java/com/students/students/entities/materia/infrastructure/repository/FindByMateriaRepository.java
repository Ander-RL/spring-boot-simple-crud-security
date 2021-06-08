package com.students.students.entities.materia.infrastructure.repository;

import com.students.students.entities.materia.domain.MateriaJpa;
import com.students.students.entities.materia.domain.dto.MateriaOutputDto;
import com.students.students.entities.materia.domain.dto.MateriaSearchInputDto;
import com.students.students.entities.materia.infrastructure.repository.port.FindByMateriaPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@AllArgsConstructor
public class FindByMateriaRepository implements FindByMateriaPort {

    EntityManager entityManager;

    @Override
    public List<MateriaOutputDto> findBy(MateriaSearchInputDto materiaSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MateriaJpa> criteriaQuery = criteriaBuilder.createQuery(MateriaJpa.class);

        Root<MateriaJpa> tipoRegistro = criteriaQuery.from(MateriaJpa.class);

        Predicate finalPredicate = getPredicate(materiaSearchInputDto, criteriaBuilder, tipoRegistro);

        criteriaQuery.where(finalPredicate);

        TypedQuery<MateriaJpa> query = entityManager.createQuery(criteriaQuery);

        List<MateriaJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new MateriaOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(MateriaSearchInputDto materiaSearchInputDto, CriteriaBuilder criteriaBuilder, Root<MateriaJpa> tipoRegistro) {
        Predicate finalPredicate = null;
        if (materiaSearchInputDto.getName() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("name"), materiaSearchInputDto.getName());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (materiaSearchInputDto.getDescription() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("description"), materiaSearchInputDto.getDescription());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (materiaSearchInputDto.getBranch() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("branch"), materiaSearchInputDto.getBranch());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
