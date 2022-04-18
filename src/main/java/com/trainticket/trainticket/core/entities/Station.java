package com.trainticket.trainticket.core.entities;

import com.trainticket.trainticket.config.exceptions.InternalValidationException;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Entity responsible to deal with stations
 *
 * @author ivo
 */
@Builder
@AllArgsConstructor(onConstructor_ = @Builder)
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "stations")
public class Station {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Builder.Default
  @Column(name = "active", nullable = false)
  private Boolean active = true;

  /**
   * Creating a station by name
   *
   * @param name the station's name
   * @return An instance of station
   */
  public static Station of(String name) {
    return Station.builder()
        .name(name)
        .active(true)
        .build();
  }

  /**
   * Method responsible to inactivate a station
   */
  public void inactivate() {
    this.active = false;
  }

  /**
   * Return a valid character based on station's name
   *
   * @param searchedName the name searched by users
   * @return a character
   */
  public Character getValidCharacter(@NonNull String searchedName)
      throws InternalValidationException {

    if (!searchedName.toLowerCase().equals(name.toLowerCase().substring(0,searchedName.length()))) {
        throw new InternalValidationException("The searched name passed is not valid");
    }

    if (name.length() == searchedName.length()) {
      return null;
    }

    return name.charAt(searchedName.length());
  }

}
