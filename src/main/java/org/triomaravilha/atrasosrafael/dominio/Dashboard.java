package org.triomaravilha.atrasosrafael.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Dashboard {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dia;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime maiorTempoAtraso;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tempoTotal;
    private float tempoEquivAlmocos;
    private float tempoEquivFilhos;
}
