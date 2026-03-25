package com.example.demo.service;

import com.example.demo.DTOs.UsageLogDTO;
import com.example.demo.domain.Appliance;
import com.example.demo.domain.UsageLog;
import com.example.demo.repository.ApplianceRepository;
import com.example.demo.repository.UsageLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageLogService {

    private final UsageLogRepository usageLogRepository;
    private final ApplianceRepository applianceRepository;

    public UsageLogService(UsageLogRepository usageLogRepository, ApplianceRepository applianceRepository) {
        this.usageLogRepository = usageLogRepository;
        this.applianceRepository = applianceRepository;
    }

    public List<UsageLog> getAllUsageLogs(){
        return usageLogRepository.findAll();
    }

    public UsageLog createUsageLog(Long applianceId, UsageLogDTO request){

        Appliance appliance = applianceRepository.findById(applianceId).orElseThrow(() -> new RuntimeException("Appliance not found"));

        UsageLog usageLog = new UsageLog();

        usageLog.setHoursUsed(request.getHoursUsed());
        usageLog.setAppliance(appliance);

        double Kwh = ((appliance.getPowerWatts() * usageLog.getHoursUsed()) / 1000);
        double cost = Kwh * 0.40;

        double weekly = cost * 7;

        usageLog.setCalculatedKwh(Kwh);
        usageLog.setCalculatedCost(weekly);

        appliance.getUsageLogs().add(usageLog);

        return usageLogRepository.save(usageLog);
    }

    public UsageLog getUsageLogById(Long usageLogId){
        return usageLogRepository.findById(usageLogId).orElseThrow(() -> new RuntimeException("Usage Log not found"));
    }

    public void deleteUsageLogById(Long usageLogId){
        usageLogRepository.deleteById(usageLogId);
    }


}
