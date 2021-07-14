package com.crudleantech.app.service;

import com.crudleantech.app.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    Optional<List<Employee>> getEmployeeByPersonOrPosition(String name, String position);
}
