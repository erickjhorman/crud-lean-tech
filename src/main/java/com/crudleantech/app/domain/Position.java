package com.crudleantech.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Position implements Serializable {
    private static final long serialVersionUID = new SecureRandom().nextLong() + 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Long idPosition;
    private String name;


    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<Employee> employees;



    private String nameToLowerCase(String name) {
        return name.toLowerCase();
    }
}
