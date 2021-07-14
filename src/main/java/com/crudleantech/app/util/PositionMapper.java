package com.crudleantech.app.util;

import com.crudleantech.app.domain.Employee;
import com.crudleantech.app.domain.Person;
import com.crudleantech.app.domain.Position;
import com.crudleantech.app.dto.EmployeeResponse;
import com.crudleantech.app.dto.PersonDto;
import com.crudleantech.app.dto.PositionResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PositionMapper {

    public static List<PositionResponse> positionToEntity(List<Position> position) {
        List<PositionResponse> positionDto = new ArrayList<>();
        position.forEach(pos -> {
            PositionResponse positionDto1 = new PositionResponse();
            positionDto1.setId(pos.getIdPosition());
            positionDto1.setName(pos.getName());
            positionDto1.setEmployees(mapEmployeeList(pos.getEmployees(), pos.getName()));
            positionDto.add(positionDto1);
        });
        return positionDto;
    }

    private static List<EmployeeResponse> mapEmployeeList(List<Employee> employees, String positionName) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary))
                .map(emp -> {
                    PersonDto person = PersonDto.builder()
                            .name(emp.getPerson().getName())
                            .lastName(emp.getPerson().getLastName())
                            .address(emp.getPerson().getAddress())
                            .cellphone(emp.getPerson().getCellphone())
                            .cityName(emp.getPerson().getCityName())
                            .build();

                    return EmployeeResponse.builder()
                            .id(emp.getId())
                            .person(person)
                            .salary(emp.getSalary())
                            .build();
                }).collect(Collectors.toList());

    }


}

