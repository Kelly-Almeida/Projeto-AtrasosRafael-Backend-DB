package org.triomaravilha.atrasosrafael.dominio;

import lombok.Getter;
import lombok.Setter;
import triomaravilha.atrasosrafael.dominio.Atrasos;

@Getter
@Setter
public class Ambiente {
    private Long id;
    private float temperatura;
    private float umidade;
    private Atrasos atraso;
    private String observacoes;

}
