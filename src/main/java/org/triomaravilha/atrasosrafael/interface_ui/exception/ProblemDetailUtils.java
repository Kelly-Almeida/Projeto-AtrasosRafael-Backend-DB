package org.triomaravilha.atrasosrafael.interface_ui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.LocalDateTime;

public class ProblemDetailUtils {

    public static ProblemDetail buildProblem(
            HttpStatus status,
            String titulo,
            String detalhe,
            String path
    ){
        ProblemDetail problema = ProblemDetail.forStatus(status);
        problema.setTitle(titulo);
        problema.setDetail(detalhe);
        problema.setInstance(URI.create(path));
        problema.setProperty("timestamp", LocalDateTime.now());
        problema.setProperty("application", "AtrasosAPI");
        return problema;
    }
}
