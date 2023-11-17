package com.betrybe.agrix.ebytr.staff.exception;

/** NotFoundException. */
public abstract class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
