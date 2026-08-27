package org.triomaravilha.atrasosrafael.infrastructure01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "dashboard")
public class DashboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dia;

    @Column(nullable = false)
    private LocalTime maiorTempoAtraso;

    @Column(nullable = false)
    private LocalTime tempoTotal;

    @Column(nullable = false)
    private float tempoEquivAlmocos;

    @Column(nullable = false)
    private float tempoEquivFilhos;
}
