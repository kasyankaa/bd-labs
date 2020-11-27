package com.iot.model.entity;

public class Factory {
  private Integer id;
  private String region;
  private String address;
  private Integer numberOfWorkers;
  private String phoneNumber;

  public Factory(String region, String address, Integer numberOfWorkers, String phoneNumber) {
    this.region = region;
    this.address = address;
    this.numberOfWorkers = numberOfWorkers;
    this.phoneNumber = phoneNumber;
  }

  public Factory(Integer id, String region, String address, Integer numberOfWorkers, String phoneNumber) {
    this.id = id;
    this.region = region;
    this.address = address;
    this.numberOfWorkers = numberOfWorkers;
    this.phoneNumber = phoneNumber;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getNumberOfWorkers() {
    return numberOfWorkers;
  }

  public void setNumberOfWorkers(Integer numberOfWorkers) {
    this.numberOfWorkers = numberOfWorkers;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "\n\nFactory:" +
            "id:" + id +
            ", region:" + region +
            ", address=" + address +
            ", numberOfWorkers:" + numberOfWorkers +
            ", phoneNumber:" + phoneNumber;
  }
}
