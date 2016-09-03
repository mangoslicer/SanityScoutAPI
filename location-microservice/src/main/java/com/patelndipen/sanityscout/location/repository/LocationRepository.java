package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.LocationDetail;

import java.util.Collection;
import java.util.List;

public interface LocationRepository {

  public List<LocationDetail> findByLocationType(String locationType);

}
