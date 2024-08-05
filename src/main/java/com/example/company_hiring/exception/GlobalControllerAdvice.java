package com.example.company_hiring.exception;

import com.example.company_hiring.controller.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {
  
  @ExceptionHandler(CompanyHiringApplicationException.class)
  public ResponseEntity<?> applicationHandler(CompanyHiringApplicationException e) {
    log.error("Error occurs {}", e.toString());
    
    return ResponseEntity
            .status(e.getErrorCode().getHttpStatus())
            .body(Result.ERROR(e.getErrorCode().name()));
  }
  
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> applicationHandler(RuntimeException e) {
    log.error("Error occurs {}", e.toString());
    
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Result.ERROR(ErrorCode.INTERNAL_SERVER_ERROR.name()));
  }
}
