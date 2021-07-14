package com.crudleantech.app.util;

import com.crudleantech.app.domain.Employee;
import com.crudleantech.app.domain.Position;
import com.crudleantech.app.dto.EmployeeResponse;
import com.crudleantech.app.dto.PersonDto;
import com.crudleantech.app.dto.PositionResponse;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PositionMapper {

    public static List<PositionResponse> positionToEntity(List<Position> position) {
        List<PositionResponse> positionDto = new ArrayList<>();
        Map<String, List<Position>> positions = position.stream().collect(Collectors.groupingBy(Position::getName));
        positions.entrySet().stream().forEach((k) -> System.out.println(k.getKey() + ":" + k.getValue()));

        positions.forEach(((s, pos) -> {
            PositionResponse positionDto1 = new PositionResponse();
            positionDto1.setId(pos.iterator().next().getIdPosition());
            positionDto1.setName(s);
            positionDto1.setEmployees(mapEmployeeList(pos.iterator().next().getEmployees()));
            positionDto.add(positionDto1);
        }));
        return positionDto;

    }

    private static List<EmployeeResponse> mapEmployeeList(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(emp -> {
                    PersonDto person = PersonDto.builder()
                            .name(emp.getPerson().getName())
                            .lastName(emp.getPerson().getLastName())
                            .address(emp.getPerson().getAddress())
                            .cellphone(emp.getPerson().getCellphone())
                            .cityName(emp.getPerson().getCityName())
                            .build();

                    return new EmployeeResponse(emp.getId(), person, emp.getSalary());
                }).collect(Collectors.toList());
    }
}

