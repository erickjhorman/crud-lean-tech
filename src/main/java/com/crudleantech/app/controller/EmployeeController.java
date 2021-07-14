package com.crudleantech.app.controller;


import com.crudleantech.app.domain.Position;
import com.crudleantech.app.dto.EmployeeRequest;
import com.crudleantech.app.dto.EmployeeResponse;
import com.crudleantech.app.dto.PositionResponse;
import com.crudleantech.app.exception.ResourceNotFoundException;
import com.crudleantech.app.repository.PositionRepository;
import com.crudleantech.app.service.EmployeeService;
import com.crudleantech.app.util.EmployeeMapper;
import com.crudleantech.app.util.PositionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EmployeeController.BASE_URL)
@AllArgsConstructor
public class EmployeeController {
    public static final String BASE_URL = "/api/v1/employees";
    private final EmployeeService employeeService;
    private final PositionRepository positionRepository;

    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.status(200).body(EmployeeMapper.positionToEmployeeDto(employeeService.getAllEmployee()));
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody EmployeeRequest employeeDto) {
        employeeService.saveEmployee(EmployeeMapper.employeeToEntity(employeeDto));
        return ResponseEntity.status(200).body("Employee saved");
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody EmployeeRequest employeeDto) {
        employeeService.updateEmployee(EmployeeMapper.employeeToEntity(employeeDto));
        return ResponseEntity.status(200).body("Employee updated");

    }

    @GetMapping("/{name}/{position}")
    public ResponseEntity<List<EmployeeResponse>> getEmployeeByNameOrPosition(@RequestParam Optional<String> nameParam, @RequestParam Optional<String> positionParam) throws ResourceNotFoundException {
        if (nameParam.get().isEmpty() && positionParam.get().isEmpty()) {
            return getAllEmployees();
        }
        List<EmployeeResponse> employees = EmployeeMapper.positionToEmployeeDto(employeeService.getEmployeeByPersonOrPosition(nameParam.get(), positionParam.get()).get());
        if (employees.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employees found");
        }
        return ResponseEntity.status(200).body(employees);
    }

    @GetMapping("/positions")
    public ResponseEntity<List<PositionResponse>> getAllPositions() {
        List<Position> positions = positionRepository.getPositions().get();

        if (positions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No positions found");
        }
        List<PositionResponse> positionDto = PositionMapper.positionToEntity(positions);
        return new ResponseEntity<>(positionDto, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody EmployeeRequest employeeDto) {
        employeeService.deleteEmployee(EmployeeMapper.employeeToEntity(employeeDto));
        return ResponseEntity.status(200).body("Employee deleted");
    }
}
