package com.crudleantech.app.serviceimpl;

import com.crudleantech.app.domain.Employee;
import com.crudleantech.app.repository.EmployeeRepository;
import com.crudleantech.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<List<Employee>> getEmployeeByPersonOrPosition(String name, String position) {
        return employeeRepository.getEmployeeByPersonOrPosition(name, position);
    }
}
