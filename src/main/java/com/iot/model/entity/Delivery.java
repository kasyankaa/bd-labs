package com.iot.model.entity;

public class Delivery {
  private Integer id;
  private Integer factoryId;
  private String carNumber;

  public Delivery(Integer id, Integer factoryId, String carNumber) {
    this.id = id;
    this.factoryId = factoryId;
    this.carNumber = carNumber;

  }

  public Delivery(Integer factoryId, String carNumber) {
    this.factoryId = factoryId;
    this.carNumber = carNumber;
  }

  @Override
  public String toString() {
    return "\n\nDelivery:" +
            "id:" + id +
            ", factoryId:" + factoryId +
            ", carNumber:" + carNumber;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getFactoryId() {
    return factoryId;
  }

  public void setFactoryId(Integer factoryId) {
    this.factoryId = factoryId;
  }

  public String getCarNumber() {
    return carNumber;
  }

  public void setCarNumber(String carNumber) {
    this.carNumber = carNumber;
  }

}
