package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.AutoColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<AutoColor, Integer> {
}
