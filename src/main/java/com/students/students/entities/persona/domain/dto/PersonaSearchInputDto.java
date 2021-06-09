package com.students.students.entities.persona.domain.dto;

import lombok.Data;

@Data
public class PersonaSearchInputDto {

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
