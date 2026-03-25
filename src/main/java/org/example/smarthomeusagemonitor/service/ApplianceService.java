package com.example.demo.service;

import com.example.demo.DTOs.ApplianceDTO;
import com.example.demo.domain.Appliance;
import com.example.demo.domain.User;
import com.example.demo.repository.ApplianceRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceService {

    private final ApplianceRepository applianceRepository;
    private final UserRepository userRepository;

    public ApplianceService(ApplianceRepository applianceRepository, UserRepository userRepository) {
        this.applianceRepository = applianceRepository;
        this.userRepository = userRepository;
    }

    public List<Appliance> getAllAppliances(){
        return applianceRepository.findAll();
    }

    public Appliance createAppliance(ApplianceDTO request, Long userId){

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Appliance appliance = new Appliance();

        appliance.setName(request.getName());
        appliance.setLocation(request.getLocation());
        appliance.setType(request.getType());
        appliance.setPowerWatts(request.getPowerWatts());

        appliance.setUser(user);
        user.getAppliances().add(appliance);

        return applianceRepository.save(appliance);
    }

    public Appliance getApplianceById(Long applianceId){
        return applianceRepository.findById(applianceId).orElseThrow(() -> new RuntimeException("Appliance not found"));
    }

    public Appliance updateAppliance(ApplianceDTO request, Long applianceId){

        Appliance appliance = applianceRepository.findById(applianceId).orElseThrow(() -> new RuntimeException("Appliance not found"));

        if(request.getName() != null ) appliance.setName(request.getName());
        if(request.getLocation() != null )  appliance.setLocation(request.getLocation());
        if(request.getType() != null )  appliance.setType(request.getType());
        if(request.getPowerWatts() != null ) appliance.setPowerWatts(request.getPowerWatts());

        return applianceRepository.save(appliance);
    }

    public void deleteApplianceById(Long applianceId){
        applianceRepository.deleteById(applianceId);
    }

}
