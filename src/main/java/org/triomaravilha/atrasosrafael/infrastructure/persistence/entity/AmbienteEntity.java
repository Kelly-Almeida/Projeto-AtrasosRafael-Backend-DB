package org.triomaravilha.atrasosrafael.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "ambiente"
)
public class AmbienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float temperatura;

    @Column(nullable = false)
    private float umidade;


 
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "atrasos_code", nullable = true)
    private AtrasosEntity atraso;

}
