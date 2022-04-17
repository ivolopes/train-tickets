package com.trainticket.trainticket.core.dto;

import com.trainticket.trainticket.core.entities.Station;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchStationsDtoTest {

  @Test
  void create(){
    var station1 = Station.of("Santa Iria");
    var station2 = Station.of("Santo Amaro de Oeiras");
    var station3 = Station.of("Santana-Cartaxo");

    var validCharacters = Arrays.asList('a', 'o');

    var stations = Arrays.asList(station1, station2, station3);
    var dto = SearchStationsDto.of(stations, validCharacters);

    assertEquals(stations.size(), dto.getStations().size());
    assertEquals(stations.get(0).getName(), dto.getStations().get(0));
    assertEquals(stations.get(1).getName(), dto.getStations().get(1));
    assertEquals(stations.get(2).getName(), dto.getStations().get(2));
    assertEquals(2, dto.getValidCharacters().size());
    assertEquals('a', dto.getValidCharacters().get(0));
    assertEquals('o', dto.getValidCharacters().get(1));
  }

}
