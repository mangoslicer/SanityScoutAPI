package com.patelndipen.sanityscout.location.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Location implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  private String locationName;

  @NotNull
  private String imagePath;

  public Location(){
  }

  public Location(String locationName, String imagePath) {
    this.locationName = locationName;
    this.imagePath = imagePath;
  }

  @NotNull
  public String getLocationName() {
    return locationName;
  }

  @NotNull
  public String getImagePath() {
    return imagePath;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

}
