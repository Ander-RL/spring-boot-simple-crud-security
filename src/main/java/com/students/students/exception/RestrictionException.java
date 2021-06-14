package com.students.students.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestrictionException extends RuntimeException{

    public RestrictionException() {
        super("No se cumplen las restricciones");
        log.error("No se cumplen las restricciones");
    }

    public RestrictionException(String message) {
        super(message);
        log.error("No se cumplen las restricciones, message -> " + message);
    }
}
