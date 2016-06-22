package com.patelndipen.sanityscout.location.repository;

import com.patelndipen.sanityscout.location.domain.Location;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;



@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

  List<Location> findByLocationType(String locationType);
}
