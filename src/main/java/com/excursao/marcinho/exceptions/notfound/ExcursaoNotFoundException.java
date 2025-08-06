package com.excursao.marcinho.exceptions.notfound;

public class ExcursaoNotFoundException extends NotFoundException {
  public ExcursaoNotFoundException() {super("O id do excursão não é valido!");}
    public ExcursaoNotFoundException(String message) {
        super(message);
    }
}
