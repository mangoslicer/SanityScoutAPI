package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.LocationApplication;
import com.patelndipen.sanityscout.location.domain.Location;

import com.patelndipen.sanityscout.location.domain.LocationDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LocationApplication.class)
public class LocationRepositoryTest {

  private static final String TEST_KEY = "fun";

  @Autowired
  RedisTemplate<String, LocationDetail> redisTemplate;

  @Autowired
  LocationRepository repository;


  @Test
  public void locationRepository_shouldReturnMultipleLocationObjectList() {
    List<LocationDetail> locations = getStubLocation();

    for (LocationDetail l : locations) {
      redisTemplate.opsForHash().put(TEST_KEY, l.getLocationName(), l);
    }

    List<LocationDetail> foundLocations = repository.findByLocationType(locations.get(0).getLocationType());
	  foundLocations = foundLocations.stream().sorted((l, l1) -> l.getLocationName().compareTo(l1.getLocationName())).collect(Collectors.toList());

    assertTrue(locations.size() == foundLocations.size());

    for (int i = 0; i < locations.size(); i++) {
      assertEquals(locations.get(i).getLocationName(), foundLocations.get(i).getLocationName());
      assertEquals(locations.get(i).getLocationType(), foundLocations.get(i).getLocationType());
      assertEquals(locations.get(i).getAddress(), foundLocations.get(i).getAddress());
      assertEquals(locations.get(i).getOpeningTime(), foundLocations.get(i).getOpeningTime());
      assertEquals(locations.get(i).getClosingTime(), foundLocations.get(i).getClosingTime());
      assertEquals(locations.get(i).getLocationLuxuries(), foundLocations.get(i).getLocationLuxuries());
      assertEquals(locations.get(i).getImagePath(), foundLocations.get(i).getImagePath());
    }
  }

  private List<LocationDetail> getStubLocation() {
    LocationDetail l = new LocationDetail();
    l.setLocationName("Candy Land");
    l.setLocationType(TEST_KEY);
    l.setAddress("1 Candy Lane");
    l.setOpeningTime("always");
    l.setClosingTime("never");
    l.setLocationLuxuries(Arrays.asList("candy", "sugar mountain"));
    l.setImagePath("health_problems.png");

    LocationDetail l1 = new LocationDetail();
    l1.setLocationName("Learning Zone");
    l1.setLocationType(TEST_KEY);
    l1.setAddress("1 Adulterated Street");
    l1.setOpeningTime("always");
    l1.setClosingTime("never");
    l1.setLocationLuxuries(Arrays.asList("knowledge", "responsibility"));
    l1.setImagePath("brick.png");

    return Arrays.asList(l, l1);
  }
}
