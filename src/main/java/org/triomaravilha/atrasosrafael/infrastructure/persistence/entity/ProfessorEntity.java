package org.triomaravilha.atrasosrafael.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "professor",
        indexes = {
                @Index(name = "idx_professor_nome", columnList = "nome")
        }
)
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
