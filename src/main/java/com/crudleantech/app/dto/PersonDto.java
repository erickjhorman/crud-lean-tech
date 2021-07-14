package com.crudleantech.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PersonDto {

    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;
}
