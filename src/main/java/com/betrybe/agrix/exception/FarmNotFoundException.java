package com.betrybe.agrix.exception;

/** FarmNotFoundException. */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
