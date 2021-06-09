package com.students.students.entities.persona.domain;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class PersonaJpa {

    public PersonaJpa(PersonaInputDto personaInputDto) {
        setUser(personaInputDto.getUser());
        setPassword(personaInputDto.getPassword());
        setSurname(personaInputDto.getSurname());
        setCompanyEmail(personaInputDto.getCompanyEmail());
        setPersonalEmail(personaInputDto.getPersonalEmail());
        setCity(personaInputDto.getCity());
        setActive(personaInputDto.getActive());
        setCreatedDate(personaInputDto.getCreatedDate());
        setTerminationDate(personaInputDto.getTerminationDate());
    }

    public PersonaJpa(PersonaOutputDto personaOutputDto) {
        setUser(personaOutputDto.getUser());
        setPassword(personaOutputDto.getPassword());
        setSurname(personaOutputDto.getSurname());
        setCompanyEmail(personaOutputDto.getCompanyEmail());
        setPersonalEmail(personaOutputDto.getPersonalEmail());
        setCity(personaOutputDto.getCity());
        setActive(personaOutputDto.getActive());
        setCreatedDate(personaOutputDto.getCreatedDate());
        setTerminationDate(personaOutputDto.getTerminationDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @GenericGenerator(
            name = "persona_seq",
            strategy = StringPrefixedSequenceIdGenerator.SEQUENCE_STRING,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM_VALUE),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PERSONA),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER_VALUE)
            })
    @Column(name = "id_persona")
    private String idPersona;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "company_email", nullable = false)
    String companyEmail;

    @Column(name = "personal_email", nullable = false)
    String personalEmail;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "active", nullable = false)
    Boolean active;

    @Column(name = "created_date", nullable = false)
    Date createdDate;

    @Column(name = "termination_date")
    Date terminationDate;
}
