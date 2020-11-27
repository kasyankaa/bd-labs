package com.iot.model.entity;

public class WorkerDelivers {
  private Integer id;
  private Integer deliveryId;
  private Integer workerId;
  private String addressOfFactory;
  private String addressOfAutomat;


  public WorkerDelivers(Integer id, Integer deliveryId, Integer workerId, String addressOfFactory, String addressOfAutomat) {
    this.id = id;
    this.deliveryId = deliveryId;
    this.workerId = workerId;
    this.addressOfFactory = addressOfFactory;
    this.addressOfAutomat = addressOfAutomat;
  }

  public WorkerDelivers(Integer deliveryId, Integer workerId, String addressOfFactory, String addressOfAutomat) {
    this.deliveryId = deliveryId;
    this.workerId = workerId;
    this.addressOfFactory = addressOfFactory;
    this.addressOfAutomat = addressOfAutomat;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(Integer deliveryId) {
    this.deliveryId = deliveryId;
  }

  public Integer getWorkerId() {
    return workerId;
  }

  public void setWorkerId(Integer workerId) {
    this.workerId = workerId;
  }

  public String getAddressOfFactory() {
    return addressOfFactory;
  }

  public void setAddressOfFactory(String addressOfFactory) {
    this.addressOfFactory = addressOfFactory;
  }

  public String getAddressOfAutomat() {
    return addressOfAutomat;
  }

  public void setAddressOfAutomat(String addressOfAutomat) {
    this.addressOfAutomat = addressOfAutomat;
  }

  @Override
  public String toString() {
    return "\n\nWorkerDelivers:" +
            "id:" + id +
            ", deliveryId:" + deliveryId +
            ", workerId:" + workerId +
            ", addressOfFactory:" + addressOfFactory +
            ", addressOfAutomat:" + addressOfAutomat;
  }
}
