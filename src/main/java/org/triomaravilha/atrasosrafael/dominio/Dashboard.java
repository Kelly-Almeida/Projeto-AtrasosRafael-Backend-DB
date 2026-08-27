package org.triomaravilha.atrasosrafael.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Dashboard {
    private Long id;
    private LocalDate dia;
    private LocalTime maiorTempoAtraso;
    private LocalTime tempoTotal;
    private float tempoEquivAlmocos;
    private float tempoEquivFilhos;
}
