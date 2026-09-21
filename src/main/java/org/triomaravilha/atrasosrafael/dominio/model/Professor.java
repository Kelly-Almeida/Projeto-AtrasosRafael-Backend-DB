package org.triomaravilha.atrasosrafael.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private Long id;
    private String nome;
    private String foto;
}
