package com.patelndipen.sanityscout.location.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class LocationDetail extends Location {

  private static final long serialVersionUID = 2L;

  @NotNull
  private String locationType;

  @NotNull
  private String address;

  @NotNull
  private String openingTime;

  @NotNull
  private String closingTime;

  @NotNull
  private List<String> locationLuxuries;

  @NotNull
  public String getLocationType() {
    return locationType;
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
  public List<String> getLocationLuxuries() {
    return locationLuxuries;
  }

  public void setLocationType(String locationType) {
    this.locationType = locationType;
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

  public void setLocationLuxuries(List<String> locationLuxuries) {
    this.locationLuxuries = locationLuxuries;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int res = 1;
    res =  prime * res + this.getLocationName().hashCode();
    res = prime * res + this.locationType.hashCode();
    res = prime * res + this.address.hashCode();
    res = prime * res + this.openingTime.hashCode();
    res = prime * res + this.closingTime.hashCode();
    res = prime * res + this.locationLuxuries.hashCode();
    res = prime * res + this.getImagePath().hashCode();

    return res;
  }
  @Override
  public boolean equals(Object obj) {

    if (obj == null) return false;
    if (this == obj) return true;
    if (this.getClass() == obj.getClass()) return true;

    LocationDetail l = (LocationDetail) obj;

    return this.getLocationName().equals(l.getLocationName()) &&
            this.locationType.equals(l.getLocationType()) &&
            this.address.equals(l.getAddress()) &&
            this.openingTime.equals(l.getOpeningTime()) &&
            this.closingTime.equals(l.getClosingTime()) &&
            this.locationLuxuries.equals(l.getLocationLuxuries()) &&
            this.getImagePath().equals(l.getImagePath());

  }

}
