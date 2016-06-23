package com.patelndipen.sanityscout.location.service;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationPreview;
import com.patelndipen.sanityscout.location.repository.LocationRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationRepository repository;

  /**
   * {@inheritDoc}
  */
  @Override
  public List<LocationPreview> findByLocationType(String locationType) {
    Assert.hasLength(locationType);

    List<LocationPreview> previews = new ArrayList<LocationPreview>();
    for (Location l : repository.findByLocationType(locationType)) {
      previews.add(new LocationPreview(l.getLocationName(), l.getImagePath()));
    }

    return previews;
  }
}
