package com.students.students.entities.persona.domain;

import com.students.students.entities.persona.domain.dto.PersonaInputDto;
import com.students.students.entities.persona.domain.dto.PersonaOutputDto;
import com.students.students.exception.InvalidDateException;
import com.students.students.exception.NullException;
import com.students.students.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@AllArgsConstructor
@NoArgsConstructor
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

    public void setIdPersona(String idPersona) {
        if (idPersona == null)
            throw new NullException("idPersona no puede ser null");
        this.idPersona = idPersona;
    }

    public void setUser(String user) {
        if (user == null)
            throw new NullException("user no puede ser null");
        this.user = user;
    }

    public void setSurname(String surname) {
        if (surname == null)
            throw new NullException("surname no puede ser null");
        this.surname = surname;
    }

    public void setCompanyEmail(String companyEmail) {
        if (companyEmail == null)
            throw new NullException("companyEmail no puede ser null");
        this.companyEmail = companyEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        if (personalEmail == null)
            throw new NullException("personalEmail no puede ser null");
        this.personalEmail = personalEmail;
    }

    public void setCity(String city) {
        if (city == null)
            throw new NullException("city no puede ser null");
        this.city = city;
    }

    public void setActive(Boolean active) {
        if (active == null)
            throw new NullException("active no puede ser null");
        this.active = active;
    }

    public void setCreatedDate(String createdDate) {
        if(createdDate == null) throw new NullException("createDate no puede ser null");

        Date parsedDated = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
            dateFormat.setLenient(false);
            parsedDated = dateFormat.parse(createdDate);
        } catch (Exception e) {
            throw new InvalidDateException("La fecha no cumple con el formato dd/MM/yyyy o no es una fecha válida.");
        }

        if (this.terminationDate != null){
            if (!this.terminationDate.after(parsedDated)){
                throw new InvalidDateException("createDate debe ser inferior a terminationDate");
            }
        }
        this.createdDate = parsedDated;
    }

    public void setTerminationDate(String terminationDate) {
        if(terminationDate == null) throw new NullException("terminationDate no puede ser null");

        Date parsedDated = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
            dateFormat.setLenient(false);
            parsedDated = dateFormat.parse(terminationDate);
        } catch (Exception e) {
            throw new InvalidDateException("La fecha no cumple con el formato dd/MM/yyyy o no es una fecha válida.");
        }

        if (this.createdDate != null){
            if (!this.createdDate.before(parsedDated)){
                throw new InvalidParameterException("createDate debe ser inferior a terminationDate");
            }
        }
        this.terminationDate = parsedDated;
    }
}
