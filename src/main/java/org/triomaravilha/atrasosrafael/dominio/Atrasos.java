package org.triomaravilha.atrasosrafael.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Atrasos {
    private Long code;
    private Professor professor;
    private LocalDate data;
    private LocalTime tempoAtraso;
    private String aula;
}
