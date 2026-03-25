package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usagelog")
@Getter
@Setter
@NoArgsConstructor
public class UsageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageLogId;
    private double hoursUsed;
    private LocalDate date;
    private double calculatedKwh;
    private double calculatedCost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "appliance_id")
    @JsonBackReference("usageLog-appliance")
    private Appliance appliance;

    @OneToMany(mappedBy = "usageLog", cascade = CascadeType.ALL)
    @JsonManagedReference("usageLog-recommendation")
    private List<Recommendation> recommendations = new ArrayList<>();
}
