package com.trainticket.trainticket.config.exceptions;

import com.trainticket.trainticket.core.dto.ExceptionDto;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TrainExceptionHandler extends ResponseEntityExceptionHandler {

  private Logger log = LogManager.getLogger();

  @ExceptionHandler(InternalValidationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public @ResponseBody ExceptionDto
                    handleInternalValidationException(final InternalValidationException exception,
                                                     final HttpServletRequest request) {
    log.error(exception);

    return ExceptionDto.builder()
        .message(exception.getMessage())
        .errorMessage(exception.getMessage())
        .requestedURI(request.getRequestURI())
        .timestamp(LocalDateTime.now()).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public @ResponseBody ExceptionDto handleException(final Exception exception,
                                                    final HttpServletRequest request) {

    log.error(exception);

    return ExceptionDto.builder()
        .message("An unexpected error happened")
        .errorMessage(exception.getMessage())
        .requestedURI(request.getRequestURI())
        .timestamp(LocalDateTime.now()).build();

  }

}
