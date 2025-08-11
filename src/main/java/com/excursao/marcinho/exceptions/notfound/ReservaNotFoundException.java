package com.excursao.marcinho.exceptions.notfound;

public class ReservaNotFoundException extends NotFoundException {
  public ReservaNotFoundException() {super("O id não é valido!");}
  public ReservaNotFoundException(String message) {
    super(message);
  }
}
