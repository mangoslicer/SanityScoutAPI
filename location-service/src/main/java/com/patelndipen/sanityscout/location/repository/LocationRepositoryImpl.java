package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

  private RedisTemplate<String, Location> redisTemplate;

  @Autowired
  public LocationRepositoryImpl(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public List<Location> findByLocationType(String locationType) {
    // Ugly casting required to format the redis's returned List<Object> into List<Location>
    return (List<Location>)(List<?>)redisTemplate.opsForHash().values(locationType);
  }

}
