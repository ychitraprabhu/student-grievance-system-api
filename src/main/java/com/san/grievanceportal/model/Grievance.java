package com.san.grievanceportal.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty !")
    private String title;

    @NotBlank(message = "Please describe your issue...")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GrievanceStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
