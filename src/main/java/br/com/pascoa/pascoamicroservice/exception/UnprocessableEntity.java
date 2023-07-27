package br.com.pascoa.pascoamicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 3275864983968991022L;

  public UnprocessableEntity() {
    super();
  }

  public UnprocessableEntity(String message) {
    super(message);
  }

  public UnprocessableEntity(Throwable cause) {
    super(cause);
  }

  public UnprocessableEntity(String message, Throwable cause) {
    super(message, cause);
  }
}
