package com.crudleantech.app.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;


@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = new SecureRandom().nextLong() + 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_person")
    private Long idPerson;
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;
}
