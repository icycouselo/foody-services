package com.icycouselo.apiwrapper.exception;

import lombok.Getter;

public class ApiServiceException extends RuntimeException {
  @Getter private final int statusCode;

  public ApiServiceException(final String message, final int statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
