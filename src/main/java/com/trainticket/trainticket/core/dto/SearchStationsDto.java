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
 * Object responsible for returning the search results
 */
@Data
@Builder
@Setter(AccessLevel.PRIVATE)
public class SearchStationsDto {

  private List<String> stations;
  private List<Character> validCharacters;

  /**
   * Method that creates the object
   *
   * @param stations entity
   * @return SearchStationsDto
   */
  public static SearchStationsDto of(@NonNull List<Station> stations,
                                     @NonNull List<Character> characters) {
    var stationsDto = StationDto.of(stations);

    return SearchStationsDto.builder()
        .stations(stationsDto.stream()
            .map(StationDto::getName)
            .collect(Collectors.toList()))
        .validCharacters(characters)
        .build();
  }

}
