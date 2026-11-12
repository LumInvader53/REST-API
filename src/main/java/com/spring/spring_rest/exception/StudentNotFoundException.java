package com.spring.spring_rest.exception;

/**
 * Exception thrown when a requested student cannot be found.
 */
public class StudentNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public StudentNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentNotFoundException(String message) {
    super(message);
  }

  public StudentNotFoundException(Throwable cause) {
    super(cause);
  }

}
