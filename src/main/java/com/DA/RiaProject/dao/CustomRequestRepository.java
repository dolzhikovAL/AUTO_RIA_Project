package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.CustomRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRequestRepository extends JpaRepository<CustomRequest, Integer> {
    List<CustomRequest> getAllByUserId(int userId);
}

