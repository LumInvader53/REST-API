package com.spring.spring_rest.entity;

/**
 * Represents an error response returned when a student-related request fails.
 */
public class StudentErrorResponse {
  private int status;
  private String message;
  private long timeStamp;

  public StudentErrorResponse() {
  }

  /**
   * Creates an error response with the specified status, message, and timestamp.
   *
   * @param status the HTTP status code
   * @param message the error message
   * @param timeStamp the time the error occurred, in milliseconds
   */
  public StudentErrorResponse(int status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

}
