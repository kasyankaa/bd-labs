package com.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "factory")
@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "number_of_workers")
    private int numberOfWorkers;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Factory() {

    }

    public Factory(Region region, String address, Integer numberOfWorkers, String phoneNumber) {
        this.region = region;
        this.address = address;
        this.numberOfWorkers = numberOfWorkers;
        this.phoneNumber = phoneNumber;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private Region region;

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @OneToMany(mappedBy = "factory", fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
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
        return "Factory["+
                "region id:" + region.getId()+", "+
                "factory id:" + id +", " +
                "address:" + address+", "+
                "number of workers:" + numberOfWorkers +", " +
                "phone number:" + phoneNumber +
                "]";
    }


}
