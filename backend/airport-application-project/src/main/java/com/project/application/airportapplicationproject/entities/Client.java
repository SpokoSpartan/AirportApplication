package com.project.application.airportapplicationproject.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
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
