package com.iot.model.entity;

import javax.persistence.*;

@Table(name = "delivery")

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "car_number")

    private String carNumber;

    public Delivery(Factory factory, String carNumber) {
        this.factory=factory;
        this.carNumber=carNumber;
    }

    public Delivery() {

    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    @ManyToOne
    @JoinColumn(name = "factory_id", referencedColumnName = "id", nullable = false)
    private Factory factory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    @Override
    public String toString() {
        return "Delivery["+
                "factory id:" + factory.getId()+", "+
                "delivery id:" + id +", " +
                "car number:" + carNumber +
                "]";
    }


}
