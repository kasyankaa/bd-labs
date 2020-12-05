package com.iot.model.entity;


import net.sf.saxon.functions.Count;

import javax.persistence.*;
import java.util.Set;

@Table(name = "region")
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "region_name")
    private String regionName;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Factory> getFactories() {
        return factories;
    }

    public void setFactories(Set<Factory> factories) {
        this.factories = factories;
    }

    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    private Set<Factory> factories;




    public Region(Country country, String regionName) {
        this.country =  country;
        this.regionName = regionName;

    }

    public Region() {

    }

    public Region(int id, String regionName, Country country) {
        this.id = id;
        this.regionName = regionName;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    @Override
    public String toString() {
        return "Region["+
                 "country id:" + country.getId()+", "+
                 "region id:" + id +", " +
                "name:" + regionName+
                "]";
    }


}
