package com.crudleantech.app.repository;

import com.crudleantech.app.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query(value = "SELECT EMPLOYEE.POSITION_ID_POSITION , * FROM POSITION  " +
            "INNER JOIN EMPLOYEE ON POSITION.id_position = EMPLOYEE.POSITION_ID_POSITION ",
            nativeQuery = true)
    Optional<List<Position>> getPositions();
}
