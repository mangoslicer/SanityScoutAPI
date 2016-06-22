package com.patelndipen.sanityscout.location.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;


@Document(collection = "locations")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

  @Id
  @NotNull
  private String locationType;

  @NotNull
  private String locationName;

  @NotNull
  private String address;

  @NotNull
  private String openingTime;

  @NotNull
  private String closingTime;

  @NotNull
  private String[] locationLuxuries;

  @NotNull
  public String getLocationType() {
    return locationType;
  }

  @NotNull
  public String getLocationName() {
    return locationName;
  }

  @NotNull
  public String getAddress() {
    return address;
  }

  @NotNull
  public String getOpeningTime() {
    return openingTime;
  }

  @NotNull
  public String getClosingTime() {
    return closingTime;
  }

  @NotNull
  public String[] getLocationLuxuries() {
    return locationLuxuries;
  }

  public void setLocationType(String locationType) {
    this.locationType = locationType;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setOpeningTime(String openingTime) {
    this.openingTime = openingTime;
  }

  public void setClosingTime(String closingTime) {
    this.closingTime = closingTime;
  }

  public void setLocationLuxuries(String[] locationLuxuries) {
    this.locationLuxuries = locationLuxuries;
  }

}
