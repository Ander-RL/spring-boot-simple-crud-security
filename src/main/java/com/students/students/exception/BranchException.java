package com.students.students.exception;

public class BranchException extends RuntimeException{

    public BranchException(String mensaje) {
        super(mensaje);
    }
    public BranchException() {
        super("El valor indicadio no pertenece a una Branch");
    }
}
