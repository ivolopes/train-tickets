package com.trainticket.trainticket.entrypoints.rest.v1;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.trainticket.trainticket.core.dto.SearchStationsDto;
import com.trainticket.trainticket.core.entities.Station;
import com.trainticket.trainticket.core.usecases.StationUseCase;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class StationControllerTest {

  @MockBean
  private StationUseCase stationUseCase;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void searchStationSuccess() throws Exception {

    var station1 = Station.of("Name1");
    var station2 = Station.of("Name2");

    var dto = SearchStationsDto.of(Arrays.asList(station1, station2),
        Arrays.asList('1', '2'));

    when(stationUseCase.stationSearch(anyString()))
        .thenReturn(dto);

    this.mockMvc.perform(get("/api/v1/stations")
              .accept(MediaType.APPLICATION_JSON)
              .param("name", "name"))
        .andDo(print())
        .andExpect(status().isOk());

  }

  @Test
  void searchStationWithoutNameParam() throws Exception {

    this.mockMvc.perform(get("/api/v1/stations")
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest());

  }
}
