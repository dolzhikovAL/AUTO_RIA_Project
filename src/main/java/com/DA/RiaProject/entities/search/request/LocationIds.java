package com.DA.RiaProject.entities.search.request;

import com.DA.RiaProject.entities.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "search_history_location_id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationIds extends BaseEntity {
    private Integer state;
    private Integer city;

    public LocationIds() {
    }

    @Column(name = "state_id")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @Column(name = "city_id")
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }
}
