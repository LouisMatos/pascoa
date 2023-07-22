package br.com.pascoa.pascoamicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardError> notFoundException(NotFoundException e,
      HttpServletRequest request) {
    log.info(e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new StandardError(HttpStatus.NOT_FOUND, e.getMessage(), request.getRequestURI()));
  }
}
