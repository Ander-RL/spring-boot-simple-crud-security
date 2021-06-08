package com.students.students.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidDateException extends RuntimeException{

    public InvalidDateException() {
        super("InvalidDateException");
        log.error("Invalid date exception");
    }

    public InvalidDateException(String message) {
        super(message);
        log.error("Invalid date exception, message -> " + message);
    }
}
