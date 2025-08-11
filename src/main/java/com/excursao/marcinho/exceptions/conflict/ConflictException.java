package com.excursao.marcinho.exceptions.conflict;

public class ConflictException extends RuntimeException {
    public ConflictException() {super("Conflito nos dados!");};
    public ConflictException(String message) {
        super(message);
    }
}
