package com.students.students.entities.persona.domain.dto;

import com.students.students.entities.persona.domain.PersonaJpa;
import lombok.Data;

@Data
public class PersonaOutputDto {

    public PersonaOutputDto(PersonaJpa personaJpa) {
        this.user = personaJpa.getUser();
        this.password = personaJpa.getPassword();
        this.surname = personaJpa.getSurname();
        this.companyEmail = personaJpa.getCompanyEmail();
        this.personalEmail = personaJpa.getPersonalEmail();
        this.city = personaJpa.getCity();
        this.active = personaJpa.getActive();
        this.createdDate = personaJpa.getCreatedDate().toString();
        this.terminationDate = personaJpa.getTerminationDate().toString();
    }

    private String user;
    private String password;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private String createdDate;
    private String terminationDate;
}
