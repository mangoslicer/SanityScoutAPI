package com.patelndipen.sanityscout.location.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Location implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  private String locationName;

  @NotNull
  private String locationType;

  @NotNull
  private String address;

  @NotNull
  private String openingTime;

  @NotNull
  private String closingTime;

  @NotNull
  private String[] locationLuxuries;

  @NotNull
  private String imagePath;

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

  @NotNull
  public String getImagePath() {
    return imagePath;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
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

  public void setLocationLuxuries(String[] locationLuxuries) {
    this.locationLuxuries = locationLuxuries;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int res = 1;
    res =  prime * res + this.locationName.hashCode();
    res = prime * res + this.locationType.hashCode();
    res = prime * res + this.address.hashCode();
    res = prime * res + this.openingTime.hashCode();
    res = prime * res + this.closingTime.hashCode();
    res = prime * res + this.locationLuxuries.hashCode();
    res = prime * res + this.imagePath.hashCode();

    return res;
  }
  @Override
  public boolean equals(Object obj) {

    if (obj == null) return false;
    if (this == obj) return true;
    if (this.getClass() == obj.getClass()) return true;

    Location l = (Location) obj;

    return this.locationName.equals(l.getLocationName()) && this.locationType.equals(l.getLocationType()) && this.address.equals(l.getAddress()) && this.openingTime.equals(l.getOpeningTime()) && this.closingTime.equals(l.getClosingTime()) && this.locationLuxuries.equals(l.getLocationLuxuries()) && this.imagePath.equals(l.getImagePath());

  }

}
