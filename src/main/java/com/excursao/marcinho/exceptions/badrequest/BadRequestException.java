package com.excursao.marcinho.exceptions.badrequest;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {super("Dados fornecidos invalido!");}
    public BadRequestException(String message) {
        super(message);
    }
}
