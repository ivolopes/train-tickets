package com.trainticket.trainticket.core.dto;

import com.trainticket.trainticket.core.entities.Station;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StationDtoTest {

  @Test
  void createSingleDto() {
    var name = "testName";
    var dto = StationDto.of(name);

    assertEquals(dto.getName(), name);
  }

  @Test
  void createListDtoFromStations() {
    var station1 = Station.of("station1");
    var station2 = Station.of("station2");
    var station3 = Station.of("station3");

    var stations = Arrays.asList(station1, station2, station3);
    var dtoList = StationDto.of(stations);

    assertEquals(stations.size(), dtoList.size());
    assertEquals(stations.get(0).getName(), dtoList.get(0).getName());
    assertEquals(stations.get(1).getName(), dtoList.get(1).getName());
    assertEquals(stations.get(2).getName(), dtoList.get(2).getName());
  }
}
