package com.betrybe.agrix.exception;

/** NotFoundException. */
public abstract class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
