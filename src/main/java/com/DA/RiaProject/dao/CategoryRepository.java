package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByValue(Integer value);
}
