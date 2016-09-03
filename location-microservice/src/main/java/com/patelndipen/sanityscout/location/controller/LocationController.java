package com.patelndipen.sanityscout.location.controller;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationResponse;
import com.patelndipen.sanityscout.location.service.LocationService;
import com.patelndipen.sanityscout.location.service.ResourceService;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;

@RestController
public class LocationController {

  @Autowired
  private LocationService locationService;
  @Autowired
  private ResourceService resourceService;

  @RequestMapping(path = "/locations/{locationType:study|grub|rec}", method = RequestMethod.GET)
  public List<LocationResponse> getLocationsByType(@PathVariable String locationType) {
    return locationService.findByLocationType(locationType).stream()
            .map(l -> new LocationResponse(l))
            .collect(Collectors.toList());
  }

  @RequestMapping(path = "{imagePath:[(^\\.)a-zA-Z0-9_]*\\.png}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
  public ResponseEntity<InputStreamResource> getPreviewByImagePath(@PathVariable String imagePath) {
    InputStreamResource img = resourceService.findPreviewByImagePath(imagePath);

    return img == null ?  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) : ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(img);
  }

}
