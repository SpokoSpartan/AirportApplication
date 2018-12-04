package com.project.application.airportapplicationproject.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Client {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne( cascade = {  CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
