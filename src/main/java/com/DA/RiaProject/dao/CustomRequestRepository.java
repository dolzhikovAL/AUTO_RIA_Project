package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.CustomRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRequestRepository extends PagingAndSortingRepository<CustomRequest, Integer> {

    Page<CustomRequest> getByUserId(int userId, Pageable p);

}

