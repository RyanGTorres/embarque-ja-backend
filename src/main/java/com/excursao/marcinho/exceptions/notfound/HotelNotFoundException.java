package com.excursao.marcinho.exceptions.notfound;

public class HotelNotFoundException extends NotFoundException {
  public HotelNotFoundException() {super("O id do hotel não é valido!");}
    public HotelNotFoundException(String message) {
        super(message);
    }
}
