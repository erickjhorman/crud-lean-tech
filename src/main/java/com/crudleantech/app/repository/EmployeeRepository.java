package com.crudleantech.app.repository;

import com.crudleantech.app.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM EMPLOYEE " +
            "INNER JOIN PERSON ON EMPLOYEE.PERSON_ID_PERSON = PERSON.id_person " +
            "INNER JOIN POSITION ON EMPLOYEE.POSITION_ID_POSITION = POSITION.id_position " +
            "WHERE PERSON.NAME = ?1  OR POSITION.NAME= ?2",
            nativeQuery = true)
    Optional<List<Employee>> getEmployeeByPersonOrPosition(String name, String position);
}
