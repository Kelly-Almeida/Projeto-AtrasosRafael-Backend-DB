package org.triomaravilha.atrasosrafael.infrastructure01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name = "ambiente")
public class AmbienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float temperatura;

    @Column(nullable = false)
    private float umidade;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atrasos_code", nullable = true)
    private AtrasosEntity atraso;

    @Column(length = 255)
    private String observacoes;
}
