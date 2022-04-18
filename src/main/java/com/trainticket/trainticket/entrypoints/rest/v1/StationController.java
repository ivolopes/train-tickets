package com.trainticket.trainticket.entrypoints.rest.v1;

import com.trainticket.trainticket.core.dto.SearchStationsDto;
import com.trainticket.trainticket.core.services.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stations")
@RequiredArgsConstructor
public class StationController {

  private final StationService stationService;

  @GetMapping
  public ResponseEntity<SearchStationsDto> search(@RequestParam(name = "name") String name) {
    return ResponseEntity.ok(stationService.stationSearch(name));
  }

}
