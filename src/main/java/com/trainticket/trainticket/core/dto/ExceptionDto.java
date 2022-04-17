package com.trainticket.trainticket.core.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

/**
 * Used to return exception information
 */
@Data
@Builder
@AllArgsConstructor(onConstructor_ = @Builder)
@Setter(AccessLevel.PRIVATE)
public class ExceptionDto {
  private String message;
  private String errorMessage;
  private LocalDateTime timestamp;
  private String requestedURI;
}
