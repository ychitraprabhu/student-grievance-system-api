package com.san.grievanceportal.controller;

import com.san.grievanceportal.dto.GrievanceRequest;
import com.san.grievanceportal.model.Grievance;
import com.san.grievanceportal.repository.GrievanceRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GrievanceController {
    private final GrievanceRepository grievanceRepository;

    public GrievanceController(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    @PostMapping("/api/grievances")
    public Grievance createGrievance(@Valid @RequestBody GrievanceRequest request) {
        Grievance grievance = new Grievance();

        grievance.setTitle(request.getTitle());
        grievance.setDescription(request.getDescription());
        grievance.setStatus("SUBMITTED");
        grievance.setCreatedAt(LocalDateTime.now());

        return grievanceRepository.save(grievance);
    }
}