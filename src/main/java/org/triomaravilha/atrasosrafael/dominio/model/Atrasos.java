package org.triomaravilha.atrasosrafael.dominio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Atrasos {
    private Long code;
    private Professor professor;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tempoAtraso;

}
