package com.crudleantech.app.util;

import com.crudleantech.app.domain.Employee;
import com.crudleantech.app.dto.EmployeeRequest;
import com.crudleantech.app.dto.EmployeeResponse;
import com.crudleantech.app.dto.PersonDto;
import com.crudleantech.app.dto.PositionDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static Employee employeeToEntity(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .id(employeeRequest.getId())
                .person(employeeRequest.getPerson())
                .position(employeeRequest.getPosition())
                .salary(employeeRequest.getSalary())
                .build();
    }

    public static List<EmployeeResponse> positionToEmployeeDto(List<Employee> employee) {
        List<EmployeeResponse> employeeDtos = new ArrayList<>();
        employee.forEach(emp -> {
            EmployeeResponse employeeRs = new EmployeeResponse();

            PersonDto person = PersonDto.builder()
                    .name(emp.getPerson().getName())
                    .lastName(emp.getPerson().getLastName())
                    .address(emp.getPerson().getAddress())
                    .cellphone(emp.getPerson().getCellphone())
                    .cityName(emp.getPerson().getCityName())
                    .build();

            PositionDto position = PositionDto
                    .builder()
                    .name(emp.getPosition().getName())
                    .build();

            employeeRs.setId(emp.getId());
            employeeRs.setSalary(emp.getSalary());
            employeeRs.setPerson(person);
            employeeRs.setPosition(position);
            employeeDtos.add(employeeRs);
        });
        return employeeDtos;
    }
}
