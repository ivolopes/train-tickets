package com.trainticket.trainticket.core.services;

import com.trainticket.trainticket.core.entities.Station;
import com.trainticket.trainticket.dataproviders.repository.StationRepository;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StationServiceTest {

  @Mock
  private StationRepository repository;

  @InjectMocks
  private StationService stationService;

  @Test
  void stationSearchSuccess() {
    var station1 = Station.of("Name1");
    var station2 = Station.of("Name2");

    var stations = Arrays.asList(station1, station2);

    when(repository.findByName(anyString()))
        .thenReturn(stations);

    var dto = stationService.stationSearch("Name");

    assertEquals(2, dto.getStations().size());
    assertEquals('1', dto.getValidCharacters().get(0));
    assertEquals('2', dto.getValidCharacters().get(1));
  }
}
