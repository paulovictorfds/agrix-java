package com.betrybe.agrix.exception;

/** CropNotFoundException. */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
