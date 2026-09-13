package com.san.grievanceportal.service;

import com.san.grievanceportal.dto.GrievanceRequest;
import com.san.grievanceportal.dto.GrievanceResponse;
import com.san.grievanceportal.model.Grievance;
import com.san.grievanceportal.model.GrievanceStatus;
import com.san.grievanceportal.repository.GrievanceRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GrievanceService {
    private final GrievanceRepository grievanceRepository;
    public GrievanceService(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    public GrievanceResponse createGrievance(GrievanceRequest grievanceRequest) {
        Grievance grievance = new Grievance();

        String title = grievanceRequest.getTitle();
        grievance.setTitle(title);

        String description = grievanceRequest.getDescription();
        grievance.setDescription(description);

        GrievanceStatus status = GrievanceStatus.SUBMITTED;
        grievance.setStatus(status);

        LocalDateTime createdAt = LocalDateTime.now();
        grievance.setCreatedAt(createdAt);

        LocalDateTime updatedAt = LocalDateTime.now();
        grievance.setUpdatedAt(updatedAt);

        Grievance savedGrievance = grievanceRepository.save(grievance);
        Long id = savedGrievance.getId();

        GrievanceResponse grievanceResponse = new GrievanceResponse();
        grievanceResponse.setId(id);
        grievanceResponse.setTitle(title);
        grievanceResponse.setDescription(description);
        grievanceResponse.setStatus(status);
        grievanceResponse.setCreatedAt(createdAt);
        grievanceResponse.setUpdatedAt(updatedAt);

        return grievanceResponse;

    }
}
