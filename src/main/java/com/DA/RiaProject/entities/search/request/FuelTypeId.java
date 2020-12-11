package com.DA.RiaProject.entities.search.request;

import com.DA.RiaProject.entities.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "search_history_fueltype_id")
public class FuelTypeId extends BaseEntity {
    private Integer fuelType;

    public FuelTypeId() {
    }

    @Column(name = "fueltype_id")
    public Integer getFuelType() {
        return fuelType;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }
}
