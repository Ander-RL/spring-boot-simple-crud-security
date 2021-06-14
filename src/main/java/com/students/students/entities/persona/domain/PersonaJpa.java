package com.students.students.entities.persona.domain;

import com.students.students.entities.student.domain.StudentJpa;
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
        this.user = personaInputDto.getUser();
        this.password = personaInputDto.getPassword();
        this.surname = personaInputDto.getSurname();
        this.companyEmail = personaInputDto.getCompanyEmail();
        this.personalEmail = personaInputDto.getPersonalEmail();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.getActive();
        this.createdDate = personaInputDto.getCreatedDate();
        this.terminationDate = personaInputDto.getTerminationDate();
    }

    public PersonaJpa(PersonaOutputDto personaOutputDto) {
        this.user = personaOutputDto.getUser();
        this.password = personaOutputDto.getPassword();
        this.surname = personaOutputDto.getSurname();
        this.companyEmail = personaOutputDto.getCompanyEmail();
        this.personalEmail = personaOutputDto.getPersonalEmail();
        this.city = personaOutputDto.getCity();
        this.active = personaOutputDto.getActive();
        this.createdDate = personaOutputDto.getCreatedDate();
        this.terminationDate = personaOutputDto.getTerminationDate();
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

    @Column(name = "user_name", nullable = false)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "company_email", nullable = false)
    private String companyEmail;

    @Column(name = "personal_email", nullable = false)
    private String personalEmail;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "termination_date")
    private Date terminationDate;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentJpa student;
}
