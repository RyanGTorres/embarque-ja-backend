package com.excursao.marcinho.exceptions.notfound;

public class EmbarqueNotFoundException extends NotFoundException {
  public EmbarqueNotFoundException() {super("O id do embarque não é valido!");}
    public EmbarqueNotFoundException(String message) {
        super(message);
    }
}
