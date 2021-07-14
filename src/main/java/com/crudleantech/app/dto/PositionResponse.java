package com.crudleantech.app.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PositionResponse {
    private Long id;
    private String name;
    private List<EmployeeResponse> employees;
}
