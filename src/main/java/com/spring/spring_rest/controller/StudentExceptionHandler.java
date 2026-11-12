package com.spring.spring_rest.controller;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles exceptions raised by student-related controllers.
 */
@ControllerAdvice
public class StudentExceptionHandler {

  /**
   * Handles a missing student and returns a not-found error response.
   *
   * @param ex the exception describing the missing student
   * @return the error response with HTTP 404 status
   */
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(
      StudentNotFoundException ex) {
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setMessage(ex.getMessage());
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  /**
   * Handles uncaught exceptions and returns a generic bad-request response.
   *
   * @param ex the exception that was thrown
   * @return the error response with HTTP 400 status
   */
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.BAD_REQUEST.value());
    err.setMessage("Invalid data. Only integers are accepted");
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles validation errors for request payloads and returns
   * field-specific messages.
   *
   * @param ex the validation exception containing the binding errors
   * @return a response entity with the validation
   *         error map and HTTP 400 status
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, String> err = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      err.put(error.getField(), error.getDefaultMessage());
    });

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }
}
