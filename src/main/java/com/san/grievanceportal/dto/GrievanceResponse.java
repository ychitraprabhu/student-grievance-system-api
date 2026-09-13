package com.san.grievanceportal.dto;

import com.san.grievanceportal.model.GrievanceStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GrievanceResponse {
    private Long id;
    private String title;
    private String description;

    private GrievanceStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
