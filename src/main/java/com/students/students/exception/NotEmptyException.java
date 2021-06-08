package com.students.students.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotEmptyException extends RuntimeException {

    public NotEmptyException(String mensaje) {
        super(mensaje);
        log.warn("Item encontrado");
    }
    public NotEmptyException() {
        super("No se pudo borrar,hay registros en la tabla");
    }
}
