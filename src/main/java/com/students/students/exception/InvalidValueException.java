package com.students.students.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidValueException extends RuntimeException{

    public InvalidValueException() {
        super("InvalidValueException");
        log.error("Invalid value exception");
    }

    public InvalidValueException(String message) {
        super(message);
        log.error("Invalid value exception, message -> " + message);
    }
}
