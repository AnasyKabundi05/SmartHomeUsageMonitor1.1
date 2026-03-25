package com.example.demo.api;

import com.example.demo.DTOs.ApplianceDTO;
import com.example.demo.domain.Appliance;
import com.example.demo.service.ApplianceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appliance")
public class ApplianceController {

    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @GetMapping
    public List<Appliance> getAllAppliances(){
        return applianceService.getAllAppliances();
    }

    @PostMapping("/user/{userId}")
    public Appliance createAppliance(@PathVariable Long userId, @RequestBody ApplianceDTO request){
        return applianceService.createAppliance(request,userId);
    }

    @GetMapping("/{applianceId}")
    public Appliance getApplianceById(@PathVariable Long applianceId){
        return applianceService.getApplianceById(applianceId);
    }

    @PutMapping("/{applianceId}")
    public Appliance updateAppliance(@RequestBody ApplianceDTO request, @PathVariable Long applianceId){
        return applianceService.updateAppliance(request,applianceId);
    }

    @DeleteMapping("/{applianceId}")
    public void deleteApplianceById(@PathVariable Long applianceId){
        applianceService.deleteApplianceById(applianceId);
    }
}
