package com.trainticket.trainticket.core.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.trainticket.trainticket.config.exceptions.InternalValidationException;
import org.junit.jupiter.api.Test;

class StationTest {

  @Test
  void inactivate() {
    var station = Station.of("Name");
    station.inactivate();

    assertEquals(false, station.getActive());
  }

  @Test
  void getValidCharactersSucess() {
    var station = Station.of("Santos");
    var searchedName = "sant";

    assertEquals('o', station.getValidCharacter(searchedName));
  }

  @Test
  void getValidCharactersError() {
    var station = Station.of("Santos");
    var searchedName = "fun";

    InternalValidationException thrown = assertThrows(InternalValidationException.class, () -> {
      station.getValidCharacter(searchedName);
    });

    assertEquals("The searched name passed is not valid", thrown.getMessage());
  }

  @Test
  void getValidCharactersNullError() {
    var station = Station.of("Santos");

    NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
      station.getValidCharacter(null);
    });

    assertEquals("searchedName is marked non-null but is null", thrown.getMessage());
  }

}
