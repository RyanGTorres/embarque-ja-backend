package com.excursao.marcinho.exceptions.notfound;

public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException() {super("O id do cliente não é valido!");}
    public ClienteNotFoundException(String message) {
        super(message);
    }
}
