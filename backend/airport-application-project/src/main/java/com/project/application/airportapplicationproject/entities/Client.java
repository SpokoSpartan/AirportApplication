package com.project.application.airportapplicationproject.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Client implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please specify the person")
    @OneToOne( cascade = {  CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
