package com.excursao.marcinho.exceptions.notfound;

public class ExcursaoOnibusNotFoundException extends NotFoundException {
    public ExcursaoOnibusNotFoundException() {super("O id de excursao com onibus não é valido!");}
    public ExcursaoOnibusNotFoundException(String message) {
        super(message);
    }
}
