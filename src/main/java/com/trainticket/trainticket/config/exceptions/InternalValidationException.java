package com.trainticket.trainticket.config.exceptions;

/**
 * Exception used on internal validations
 *
 */
public class InternalValidationException extends RuntimeException {

  public InternalValidationException(String message) {
    super(message);
  }

}
