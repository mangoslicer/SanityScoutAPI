package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.Location;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.core.HashOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

  private static final String LOCATION_DATA_FOLDER = "/location_data/";
  private static final String STUDY_JSON = "study_locations.json";
  private static final String STUDY_LOCATION_KEY = "study";

  private RedisTemplate<String, Location> redisTemplate;

  @Autowired
  public LocationRepositoryImpl(RedisTemplate<String, Location> redisTemplate) {
    this.redisTemplate = redisTemplate;

    //Load location data into redis
    if (redisTemplate.opsForHash().size("study") == 0) {
      loadInitialStudyData(redisTemplate.opsForHash());
    }
  }

  private void loadInitialStudyData(HashOperations<String, String, Location> hashOps) {
    InputStream studyLocationsJson = null;
    try {
      studyLocationsJson = (new ClassPathResource(LOCATION_DATA_FOLDER + STUDY_JSON)).getInputStream();
    } catch (IOException e) {
      e.printStackTrace();
      //System.out.println("\n\n\nThe cause was:\n" + e.getMessage() + "\n\n\n");
    }

    final ObjectMapper mapper = new ObjectMapper();
    List<Location> studyLocations = null;
    try {
      studyLocations = mapper.readValue(studyLocationsJson, new TypeReference <List<Location>>() {});
    } catch (Exception e) {
      e.printStackTrace();
    }

    for (Location l : studyLocations) {
      hashOps.put(STUDY_LOCATION_KEY, l.getLocationName(), l);
    }
  }

  public List<Location> findByLocationType(String locationType) {
    return (List<Location>)(List<?>)redisTemplate.opsForHash().values(locationType);
  }

}
