package com.trainticket.trainticket.core.dto;

import com.trainticket.trainticket.core.entities.Station;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

/**
 * An object responsible to return the station's information
 */
@Data
@Builder
@Setter(AccessLevel.PRIVATE)
public class StationDto {

  private String name;

  /**
   * Method that creates a list of StationDto by a list of station's entity
   *
   * @param stations a list of station's entity
   * @return List<StationDto> a list of station's dto
   */
  public static List<StationDto> of(@NonNull List<Station> stations) {
    return stations.stream()
        .map(s -> StationDto.of(s.getName()))
        .collect(Collectors.toList());
  }

  /**
   * Method that creates the object by name
   *
   * @param name the station's name
   * @return StationDto
   */
  public static StationDto of(@NonNull String name) {
    return StationDto.builder()
        .name(name)
        .build();
  }
}
