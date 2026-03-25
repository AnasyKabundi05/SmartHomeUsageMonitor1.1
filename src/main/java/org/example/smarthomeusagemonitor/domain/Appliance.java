package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appliance")
@Getter
@Setter
@NoArgsConstructor
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applianceId;
    private String name;
    private String type;
    private double powerWatts;
    private String location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-appliance")
    private User user;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL)
    @JsonManagedReference("usageLog-appliance")
    private List<UsageLog> usageLogs = new ArrayList<>();

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL)
    @JsonManagedReference("appliance-recommendation")
    private List<Recommendation> recommendations = new ArrayList<>();
}
