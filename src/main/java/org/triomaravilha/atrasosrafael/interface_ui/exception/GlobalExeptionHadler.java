package org.triomaravilha.atrasosrafael.interface_ui.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.triomaravilha.atrasosrafael.interface_ui.exception.ProblemDetailUtils.buildProblem;

@RestControllerAdvice
public class GlobalExeptionHadler {

    //NÃO ACHEI
    @ExceptionHandler(
            NoSuchElementException.class
    )public ProblemDetail handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
        return buildProblem(
                HttpStatus.NOT_FOUND,
                "ID não encontrado!!",
                "Não apresenta nenhum registro com esse ID",
                request.getRequestURI()
        );
    }

    //MANDEI ERRADO
    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = buildProblem(
                HttpStatus.BAD_REQUEST,
                "Erro de validação",
                "Um ou mais campos são inválidos",
                request.getRequestURI()
        );

        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> erros.put(
                error.getField(),
                error.getDefaultMessage()
        ));
        problemDetail.setProperty("erros", erros);
        return problemDetail;
    }

    //DADOS DO TIPO ERRADO
    @ExceptionHandler(
            MethodArgumentTypeMismatchException.class
    )public ProblemDetail handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        return buildProblem(
                HttpStatus.BAD_REQUEST,
                "Parâmetros incorretos.",
                String.format(
                        "O parâmetro '%s' deve ser do tipo '%s'. Valor recebido '%s'",
                        ex.getName(),
                        ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName(): "desconhecido",
                        ex.getValue()
                ),
                request.getRequestURI()
        );
    }

    //JSON ESTÁ PODRE
    @ExceptionHandler(
            HttpMessageNotReadableException.class
    )public  ProblemDetail handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return buildProblem(
                HttpStatus.BAD_REQUEST,
                "Arquivo de envio contêm erro",
                String.format(
                        "O arquivo aprensenta essa inconsistência: %s",
                        ex.getMessage()
                ),
                request.getRequestURI()
        );
    }

    //Algo nulo
    @ExceptionHandler(
            NullPointerException.class
    )public  ProblemDetail handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        return buildProblem(
                HttpStatus.BAD_REQUEST,
                "Os atributos não podem ser null",
                "Campo not null recebeu um valor nulo em sua transação",
                request.getRequestURI()
        );
    }

}
