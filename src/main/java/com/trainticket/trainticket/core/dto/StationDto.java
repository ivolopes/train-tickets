package com.trainticket.trainticket.core.dto;

import com.trainticket.trainticket.core.entities.Station;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@Builder
@Setter(AccessLevel.PRIVATE)
public class StationDto {

  private String name;

  public static List<StationDto> of(@NonNull List<Station> stations) {
    return stations.stream()
        .map(s -> StationDto.of(s.getName()))
        .collect(Collectors.toList());
  }

  public static StationDto of(@NonNull String name) {
    return StationDto.builder()
        .name(name)
        .build();
  }
}
