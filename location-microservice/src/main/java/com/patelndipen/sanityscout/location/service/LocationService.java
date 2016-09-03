package com.patelndipen.sanityscout.location.service;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationResponse;

import java.util.List;

public interface LocationService {

  /**
   * Finds all locations with the provided location type
   *
   * @param locationType
   * @return list of LocationResponse objects
  */
  List<Location> findByLocationType(String locationType);

}
