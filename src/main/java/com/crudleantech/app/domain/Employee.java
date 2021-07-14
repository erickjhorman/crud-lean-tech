package com.crudleantech.app.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {
    private static final long serialVersionUID = new SecureRandom().nextLong() + 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(referencedColumnName = "id_person")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Person person;

    @JoinColumn(referencedColumnName = "id_position")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Position position;

    private Integer salary;
}
