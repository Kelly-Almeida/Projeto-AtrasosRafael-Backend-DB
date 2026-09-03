package org.triomaravilha.atrasosrafael.dominio.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Ambiente {
    private Long id;
    private float temperatura;
    private float umidade;
    private Atrasos atraso;

}
