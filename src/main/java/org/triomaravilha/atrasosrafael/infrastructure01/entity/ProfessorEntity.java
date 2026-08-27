package org.triomaravilha.atrasosrafael.infrastructure01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "professor")
public class  ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String foto;

}
