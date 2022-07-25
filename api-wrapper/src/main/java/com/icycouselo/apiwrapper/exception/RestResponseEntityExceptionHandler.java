package com.icycouselo.apiwrapper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private static final String TIMESTAMP = "timestamp";
  private static final String MESSAGE = "message";

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleCityNotFoundException(
      ResourceNotFoundException ex, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put(TIMESTAMP, LocalDateTime.now());
    body.put(MESSAGE, "Resource not found");

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoDataFoundException.class)
  public ResponseEntity<Object> handleNoDataFoundException(
      NoDataFoundException ex, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put(TIMESTAMP, LocalDateTime.now());
    body.put(MESSAGE, "No data found");

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NotRecipeInstanceException.class)
  public ResponseEntity<Object> handleNotExtractedRecipeInstance(
      NotRecipeInstanceException ex, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put(TIMESTAMP, LocalDateTime.now());
    body.put(MESSAGE, "No valid recipe found");

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
