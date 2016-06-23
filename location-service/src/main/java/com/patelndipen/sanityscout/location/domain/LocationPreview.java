package com.patelndipen.sanityscout.location.domain;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Restrict Location object access to only that which is required for the LocationPreview
*/

public class LocationPreview {

  @NotNull
  @JsonProperty("location_name")
  private String locationName;

  @NotNull
  @JsonProperty("image_path")
  private String imagePath;

  public LocationPreview(String locationName, String imagePath) {
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

}
