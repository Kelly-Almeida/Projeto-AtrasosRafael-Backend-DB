package triomaravilha.atrasosrafael.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ambiente {
    private Long id;
    private float temperatura;
    private float umidade;
    private Atrasos atraso;
    private String observacoes;

}
