package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.domain.LocationDetail;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.core.HashOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.annotation.PostConstruct;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

  @Autowired
  private RedisTemplate<String, LocationDetail> redisTemplate;

  @PostConstruct
  private void populateRedis() {
    String LOCATION_DATA_FOLDER = "/location_data/";
    final String[] locationJsonFileNames = {"study_locations.json", "grub_locations.json", "rec_locations.json"};

    final List<LocationDetail> locations = new ArrayList<LocationDetail>();
    final ObjectMapper mapper = new ObjectMapper();

    try {
      for (String locationJsonFile : locationJsonFileNames) {
        InputStream locationJson = (new ClassPathResource(LOCATION_DATA_FOLDER + locationJsonFile)).getInputStream();
        locations.addAll(mapper.readValue(locationJson, new TypeReference <List<LocationDetail>>() {}));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    locations.stream().forEach(l -> {
      redisTemplate.opsForHash().putIfAbsent(l.getLocationType(), l.getLocationName(), l);
    });
  }

  public List<LocationDetail> findByLocationType(String locationType) {
    return (List<LocationDetail>)(List<?>) redisTemplate.opsForHash().values(locationType);
  }


}
