package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.Location;

import java.util.List;

public interface LocationRepository {

  public List<Location> findByLocationType(String locationType);

}
