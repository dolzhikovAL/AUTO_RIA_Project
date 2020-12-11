package com.DA.RiaProject.dao;

import com.DA.RiaProject.entities.search.request.TicketSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketSubmissionRepository extends JpaRepository<TicketSubmission, Integer> {
}
