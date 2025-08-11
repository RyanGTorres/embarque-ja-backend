package com.excursao.marcinho.exceptions.notfound;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {super("O id não é valido!");}
    public NotFoundException(String message) {
        super(message);
    }
}
