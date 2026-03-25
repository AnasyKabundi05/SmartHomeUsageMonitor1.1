package com.example.demo.DTOs;

import com.example.demo.domain.Appliance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplianceDTO {
    private Long applianceId;
    private String name;
    private String type;
    private Double powerWatts;
    private String location;

    public ApplianceDTO(Appliance appliance){
        this.applianceId = appliance.getApplianceId();
        this.name = appliance.getName();
        this.type = appliance.getType();
        this.powerWatts = appliance.getPowerWatts();
        this.location = appliance.getLocation();;
    }
}
