package com.students.students.entities.study.infrastucture.repository;

import com.students.students.entities.study.domain.StudyJpa;
import com.students.students.entities.study.domain.dto.StudyOutputDto;
import com.students.students.entities.study.domain.dto.StudySearchInputDto;
import com.students.students.entities.study.infrastucture.repository.port.FindByStudyPort;
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
@AllArgsConstructor
@Repository
public class FindByStudyRepository implements FindByStudyPort {

    EntityManager entityManager;

    @Override
    public List<StudyOutputDto> findBy(StudySearchInputDto studySearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudyJpa> criteriaQuery = criteriaBuilder.createQuery(StudyJpa.class);

        Root<StudyJpa> study = criteriaQuery.from(StudyJpa.class);

        Predicate finalPredicate = getPredicate(studySearchInputDto, criteriaBuilder, study);

        criteriaQuery.where(finalPredicate);

        TypedQuery<StudyJpa> query = entityManager.createQuery(criteriaQuery);

        List<StudyJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new StudyOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(StudySearchInputDto studySearchInputDto, CriteriaBuilder criteriaBuilder, Root<StudyJpa> study) {
        Predicate finalPredicate = null;

        if (studySearchInputDto.getIdStudent() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("idStudent"), studySearchInputDto.getIdStudent());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }

        if (studySearchInputDto.getIdMateria() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("idMateria"), studySearchInputDto.getIdMateria());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studySearchInputDto.getNote() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("grade"), studySearchInputDto.getNote());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studySearchInputDto.getComent() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("coment"), studySearchInputDto.getComent());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studySearchInputDto.getInitialDate() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("initialDate"), studySearchInputDto.getInitialDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (studySearchInputDto.getFinishDate() != null){
            Predicate predicado = criteriaBuilder.equal(study.get("finishDate"), studySearchInputDto.getFinishDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
