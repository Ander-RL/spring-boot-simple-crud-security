package com.students.students.entities.persona.domain.dto;

import com.students.students.entities.persona.domain.PersonaJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaInputDto {

    public PersonaInputDto(PersonaJpa personaJpa) {
        this.user = personaJpa.getUser();
        this.password = personaJpa.getPassword();
        this.surname = personaJpa.getSurname();
        this.companyEmail = personaJpa.getCompanyEmail();
        this.personalEmail = personaJpa.getPersonalEmail();
        this.city = personaJpa.getCity();
        this.active = personaJpa.getActive();
        this.createdDate = personaJpa.getCreatedDate();
        this.terminationDate = personaJpa.getTerminationDate();
    }

    private String user;
    private String password;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private Date terminationDate;
}
