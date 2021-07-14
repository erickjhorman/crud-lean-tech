package com.crudleantech.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private PersonDto person;
    private PositionDto position;
    private Integer salary;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long id, PersonDto person, Integer salary) {
        this.id = id;
        this.person = person;
        this.salary = salary;
    }
}
