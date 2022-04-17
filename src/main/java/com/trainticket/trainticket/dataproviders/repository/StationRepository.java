package com.trainticket.trainticket.dataproviders.repository;

import com.trainticket.trainticket.core.entities.Station;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Responsible for dealing with station table
 *
 * @author ivo
 */
@Repository
public interface StationRepository extends CrudRepository<Station, UUID> {

  @Query("select s from Station s where LOWER(name) like LOWER(concat(?1, '%'))")
  List<Station> findByName(String name);

}
