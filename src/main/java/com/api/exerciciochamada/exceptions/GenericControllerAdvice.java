package com.api.exerciciochamada.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice extends Exception {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);


    @ExceptionHandler({NomeAlunoException.class})
    public ResponseEntity<String> handleNome() {
        final String nomeAlunoException = "Nome não encontrado!";
        LOGGER.error(nomeAlunoException);
        return new ResponseEntity<>(nomeAlunoException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IdAlunoException.class})
    public ResponseEntity<String> handleId() {
        final String idAlunoException = "Id não encontrado!";
        LOGGER.error(idAlunoException);
        return new ResponseEntity<>(idAlunoException, HttpStatus.NOT_FOUND);
    }

}
