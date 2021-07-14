package com.crudleantech.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private PersonDto person;
    private PositionDto position;
    private Integer salary;

    public EmployeeResponse(Long id, PositionDto position, Integer salary) {
        this.id = id;
        this.position = position;
        this.salary = salary;
    }
}
