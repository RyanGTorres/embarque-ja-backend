package com.excursao.marcinho.exceptions.notfound;

public class OnibusNotFoundException extends NotFoundException {
    public OnibusNotFoundException() {super("O id do onibus não é valido!");}
    public OnibusNotFoundException(String message) {
        super(message);
    }
}
