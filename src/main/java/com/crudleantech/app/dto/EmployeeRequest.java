package com.crudleantech.app.dto;

import com.crudleantech.app.domain.Person;
import com.crudleantech.app.domain.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeRequest {
    private Long id;
    private Person person;
    private Position position;
    private Integer salary;
}
