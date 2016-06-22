package com.patelndipen.sanityscout.location.service;

import com.patelndipen.sanityscout.location.domain.Location;

import java.util.List;

public interface LocationService {

  /**
   * Finds all locations with the provided location type
   *
   * @param locationType
   * @return list of locations
  */
  List<Location> findByLocationType(String locationType);

}
