package com.students.students.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullException extends RuntimeException{

    public NullException() {
        super("Los valores no pueden ser nulos");
        log.error("Null exception");
    }

    public NullException(String message) {
        super(message);
        log.error("Null exception, message -> " + message);
    }
}
