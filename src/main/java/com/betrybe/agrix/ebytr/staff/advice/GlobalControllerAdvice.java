package com.betrybe.agrix.ebytr.staff.advice;

import com.betrybe.agrix.ebytr.staff.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** ControllerAdvice. */
@ControllerAdvice
public class GlobalControllerAdvice {

  /** Handle Not Found. */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFound(NotFoundException e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(e.getMessage());
  }
}
