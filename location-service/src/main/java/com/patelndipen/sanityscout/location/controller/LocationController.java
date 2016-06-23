package com.patelndipen.sanityscout.location.controller;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationPreview;
import com.patelndipen.sanityscout.location.service.LocationService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LocationController {

  @Autowired
  private LocationService locationService;


  @RequestMapping(path = "/locations/{locationType:study|grub|rec}", method = RequestMethod.GET)
  public List<LocationPreview> getLocationsByType(@PathVariable String locationType) {
    return locationService.findByLocationType(locationType);
  }

}
