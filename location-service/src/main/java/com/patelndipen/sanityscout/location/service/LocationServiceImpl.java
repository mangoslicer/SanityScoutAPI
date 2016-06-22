package com.patelndipen.sanityscout.location.service;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.repository.LocationRepository;

import java.util.List;

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
  public List<Location> findByLocationType(String locationType) {
    Assert.hasLength(locationType);
    return repository.findByLocationType(locationType);
  }
}
