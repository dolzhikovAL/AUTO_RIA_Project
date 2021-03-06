package com.DA.RiaProject.entities.search.request;

import com.DA.RiaProject.entities.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Optional;

@Component
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private int value;

  public Category() {
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


    public void setValue(int value) {
        this.value = value;
    }
}
