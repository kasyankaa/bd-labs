package com.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country_name")
    private String countryName;

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private Set<Region> regions;


    public Country(String countryName) {
        this.countryName=countryName;
    }

    public Country() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Country["+
                "id :" + id +","+
                "name=" + countryName +
                "]";
    }
}

