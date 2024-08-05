package com.example.company_hiring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  // 4xx - 1000
  COMPANY_NOT_FOUND(HttpStatus.NOT_FOUND, "Company is not found"),
  // 5xx -5000
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
  ;
  
  private HttpStatus httpStatus;
  private String message;
}
