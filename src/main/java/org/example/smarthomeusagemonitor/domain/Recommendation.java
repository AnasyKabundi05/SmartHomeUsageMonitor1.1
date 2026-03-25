package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recommendation")
@Getter
@Setter
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;
    private String message;
    private double potentialSavings;
    private LocalDate createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "appliance_id")
    @JsonBackReference("appliance-recommendation")
    private Appliance appliance;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usagelog_id")
    @JsonBackReference("usageLog-recommendation")
    private UsageLog usageLog;
}
