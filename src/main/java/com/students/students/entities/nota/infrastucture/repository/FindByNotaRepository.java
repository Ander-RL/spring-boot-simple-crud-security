package com.students.students.entities.nota.infrastucture.repository;

import com.students.students.entities.nota.domain.NotaJpa;
import com.students.students.entities.nota.domain.dto.NotaOutputDto;
import com.students.students.entities.nota.domain.dto.NotaSearchInputDto;
import com.students.students.entities.nota.infrastucture.repository.port.FindByNotaPort;
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
public class FindByNotaRepository implements FindByNotaPort {

    EntityManager entityManager;

    @Override
    public List<NotaOutputDto> findBy(NotaSearchInputDto notaSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NotaJpa> criteriaQuery = criteriaBuilder.createQuery(NotaJpa.class);

        Root<NotaJpa> nota = criteriaQuery.from(NotaJpa.class);

        Predicate finalPredicate = getPredicate(notaSearchInputDto, criteriaBuilder, nota);

        criteriaQuery.where(finalPredicate);

        TypedQuery<NotaJpa> query = entityManager.createQuery(criteriaQuery);

        List<NotaJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new NotaOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(NotaSearchInputDto notaSearchInputDto, CriteriaBuilder criteriaBuilder, Root<NotaJpa> nota) {
        Predicate finalPredicate = null;

        if (notaSearchInputDto.getIdStudent() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("idStudent"), notaSearchInputDto.getIdStudent());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }

        if (notaSearchInputDto.getIdMateria() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("idMateria"), notaSearchInputDto.getIdMateria());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (notaSearchInputDto.getIdTipoRegistro() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("idTipoRegistro"), notaSearchInputDto.getIdTipoRegistro());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (notaSearchInputDto.getNote() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("grade"), notaSearchInputDto.getNote());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (notaSearchInputDto.getComent() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("coment"), notaSearchInputDto.getComent());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (notaSearchInputDto.getBranchEnum() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("branch"), notaSearchInputDto.getBranchEnum());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (notaSearchInputDto.getCreationDate() != null){
            Predicate predicado = criteriaBuilder.equal(nota.get("creationDate"), notaSearchInputDto.getCreationDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
