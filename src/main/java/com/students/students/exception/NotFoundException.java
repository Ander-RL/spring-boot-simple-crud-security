package com.students.students.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundException extends RuntimeException {

    public NotFoundException(String mensaje) {
        super(mensaje);
        log.warn("Item no encontrado");
    }
    public NotFoundException() {
        super("No se pudo encontrar al estudiante");
    }
}
