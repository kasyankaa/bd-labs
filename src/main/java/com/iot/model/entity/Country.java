package com.iot.model.entity;

public class Country {
  private Integer id;
  private String countryName;

  public Country(Integer id, String countryName) {
    this.id = id;
    this.countryName = countryName;
  }

  public Country(String countryName) {
    this.countryName = countryName;
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

  @Override
  public String toString() {
    return "\n\nCountry: id: " + id + ", name: " + countryName;
  }
}
