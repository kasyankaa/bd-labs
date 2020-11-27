package com.iot.model.entity;

public class Region {
  private Integer id;
  private String countryName;
  private String regionName;


  public Region(String countryName, String regionName) {
    this.countryName = countryName;
    this.regionName = regionName;
  }

  public Region(Integer id, String countryName, String regionName) {
    this.id = id;
    this.countryName = countryName;
    this.regionName = regionName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  @Override
  public String toString() {
    return "\n\nRegion: id: " + id + ", region: " + regionName + ", country: " + countryName;
  }
}



