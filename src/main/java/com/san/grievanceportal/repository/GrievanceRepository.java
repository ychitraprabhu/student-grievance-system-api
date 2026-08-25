package com.san.grievanceportal.repository;

import com.san.grievanceportal.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

}
