package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Integer> {

    boolean existsByValue(Integer fuelType);
}
