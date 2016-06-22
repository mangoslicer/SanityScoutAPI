package com.patelndipen.sanityscout.location.controller;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.service.LocationService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LocationController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private LocationService locationService;


  @RequestMapping(path = "/locations/{locationType}", method = RequestMethod.GET)
  public List<Location> getLocationsByType(@PathVariable String locationType) {
    return locationService.findByLocationType(locationType);
  }

}
