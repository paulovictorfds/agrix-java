package com.betrybe.agrix.ebytr.staff.exception;

/** CropNotFoundException. */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
