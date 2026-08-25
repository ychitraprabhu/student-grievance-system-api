package com.san.grievanceportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrievanceRequest {
    @NotBlank(message = "Title cannot be empty!")
    private String title;

    @NotBlank(message = "Description cannot be empty!")
    private String description;
}
