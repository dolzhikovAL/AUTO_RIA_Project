package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.AutoBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoBrandRepository extends JpaRepository<AutoBrand, Integer> {
    @Query("FROM AutoBrand WHERE category_id=?1")
    List<AutoBrand> getAllByCategory(int id);
}