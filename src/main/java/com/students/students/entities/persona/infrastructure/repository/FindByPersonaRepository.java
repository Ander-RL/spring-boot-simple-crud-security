package com.students.students.entities.persona.infrastructure.repository;

import com.students.students.entities.persona.domain.PersonaJpa;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.entities.persona.domain.dto.PersonaSearchInputDto;
import com.students.students.entities.persona.infrastructure.repository.port.FindByPersonaPort;
import com.students.students.entities.tiporegistro.domain.TipoRegistroJpa;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroOutputDto;
import com.students.students.entities.tiporegistro.domain.dto.TipoRegistroSearchInputDto;
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
public class FindByPersonaRepository implements FindByPersonaPort {

    EntityManager entityManager;

    @Override
    public List<PersonaOutputDto> findBy(PersonaSearchInputDto personaSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaJpa> criteriaQuery = criteriaBuilder.createQuery(PersonaJpa.class);

        Root<PersonaJpa> persona = criteriaQuery.from(PersonaJpa.class);

        Predicate finalPredicate = getPredicate(personaSearchInputDto, criteriaBuilder, persona);

        criteriaQuery.where(finalPredicate);

        TypedQuery<PersonaJpa> query = entityManager.createQuery(criteriaQuery);

        List<PersonaJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new PersonaOutputDto(item))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(PersonaSearchInputDto personaSearchInputDto, CriteriaBuilder criteriaBuilder, Root<PersonaJpa> persona) {
        Predicate finalPredicate = null;
        if (personaSearchInputDto.getUser() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("user"), personaSearchInputDto.getUser());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getPassword() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("password"), personaSearchInputDto.getPassword());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getSurname() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("surname"), personaSearchInputDto.getSurname());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getCompanyEmail() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("companyEmail"), personaSearchInputDto.getCompanyEmail());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getPersonalEmail() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("personalEmail"), personaSearchInputDto.getPersonalEmail());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getCity() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("city"), personaSearchInputDto.getCity());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getActive() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("active"), personaSearchInputDto.getActive());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getCreatedDate() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("createdDate"), personaSearchInputDto.getCreatedDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (personaSearchInputDto.getTerminationDate() != null){
            Predicate predicado = criteriaBuilder.equal(persona.get("terminationDate"), personaSearchInputDto.getTerminationDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
