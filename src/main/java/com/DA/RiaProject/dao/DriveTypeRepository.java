package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.DriveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveTypeRepository extends JpaRepository<DriveType, Integer> {
    @Query("FROM DriveType WHERE category_id=?1")
    List<DriveType> findByCategory(int categoryId);
}