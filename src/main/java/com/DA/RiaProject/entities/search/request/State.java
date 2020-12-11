package com.DA.RiaProject.entities.search.request;

import com.DA.RiaProject.entities.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Table(name = "states")
public class State extends BaseEntity {
    private String name;
    private int value;
    private List<City> cities;

    public State() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "value")
    public int getValue() {
        return value;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
