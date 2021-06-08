package com.students.students.entities.tiporegistro.infrastructure.repository;

import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;
import com.students.students.entities.tiporegistro.infrastructure.repository.port.FindByTipoRegistroPort;
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
public class FindByTipoRegistroRepository implements FindByTipoRegistroPort {

    EntityManager entityManager;

    @Override
    public List<TipoRegistroOutputDto> findBy(TipoRegistroSearchInputDto tipoRegistroSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoRegistroJpa> criteriaQuery = criteriaBuilder.createQuery(TipoRegistroJpa.class);

        Root<TipoRegistroJpa> tipoRegistro = criteriaQuery.from(TipoRegistroJpa.class);

        Predicate finalPredicate = getPredicate(tipoRegistroSearchInputDto, criteriaBuilder, tipoRegistro);

        criteriaQuery.where(finalPredicate);

        TypedQuery<TipoRegistroJpa> query = entityManager.createQuery(criteriaQuery);

        List<TipoRegistroJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new TipoRegistroOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(TipoRegistroSearchInputDto tipoRegistroSearchInputDto, CriteriaBuilder criteriaBuilder, Root<TipoRegistroJpa> tipoRegistro) {
        Predicate finalPredicate = null;
        if (tipoRegistroSearchInputDto.getName() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("name"), tipoRegistroSearchInputDto.getName());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (tipoRegistroSearchInputDto.getLastUpdate() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("lastUpdate"), tipoRegistroSearchInputDto.getLastUpdate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (tipoRegistroSearchInputDto.getActivo() != null){
            Predicate predicado = criteriaBuilder.equal(tipoRegistro.get("activo"), tipoRegistroSearchInputDto.getActivo());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
