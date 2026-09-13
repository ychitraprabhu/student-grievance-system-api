package com.san.grievanceportal.controller;

import com.san.grievanceportal.dto.GrievanceRequest;
import com.san.grievanceportal.dto.GrievanceResponse;
import com.san.grievanceportal.service.GrievanceService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrievanceController {
    private final GrievanceService grievanceService;

    public GrievanceController(GrievanceService grievanceService) {
        this.grievanceService = grievanceService;
    }

    @PostMapping("/api/grievances")
    public ResponseEntity<GrievanceResponse> createGrievance(@Valid @RequestBody GrievanceRequest request) {
        GrievanceResponse response = grievanceService.createGrievance(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}