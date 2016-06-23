package com.patelndipen.sanityscout.location.service;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationPreview;

import java.util.List;

public interface LocationService {

  /**
   * Finds all locations with the provided location type
   *
   * @param locationType
   * @return list of locations
  */
  List<LocationPreview> findByLocationType(String locationType);

}
