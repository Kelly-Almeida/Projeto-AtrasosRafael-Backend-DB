package org.triomaravilha.atrasosrafael.infrastructure01.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.triomaravilha.atrasosrafael.dominio.Professor;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "atrasos")
public class AtrasosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntity professor;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tempoAtraso;

    @Column(nullable = false)
    private String aula;
}
