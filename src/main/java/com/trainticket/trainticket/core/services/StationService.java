package com.trainticket.trainticket.core.services;

import com.trainticket.trainticket.core.dto.SearchStationsDto;
import com.trainticket.trainticket.core.entities.Station;
import com.trainticket.trainticket.dataproviders.repository.StationRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Station service
 */
@Service
@RequiredArgsConstructor
public class StationService {

  private final StationRepository repository;

  /**
   * Search the stations by name
   *
   * @param name station's name
   * @return return an object with the station's name and valid characters
   */
  public SearchStationsDto stationSearch(String name) {
    var stations = this.findByNameStartsWith(name);

    var validCharacters = stations.stream()
                            .map(s -> s.getValidCharacter(name))
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());

    return SearchStationsDto.of(stations,
        validCharacters.stream().distinct().collect(Collectors.toList()));
  }

  /**
   * Search all stations that starts with the name passed
   *
   * @param name station's name
   * @return a list of stations
   */
  private List<Station> findByNameStartsWith(String name) {
    return repository.findByName(name);
  }

}
