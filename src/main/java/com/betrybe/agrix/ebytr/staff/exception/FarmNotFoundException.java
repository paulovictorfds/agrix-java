package com.betrybe.agrix.ebytr.staff.exception;

/** FarmNotFoundException. */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
