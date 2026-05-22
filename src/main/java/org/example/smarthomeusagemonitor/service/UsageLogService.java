package org.example.smarthomeusagemonitor.service;

import org.example.smarthomeusagemonitor.DTOs.UsageLogDTO;
import org.example.smarthomeusagemonitor.domain.Appliance;
import org.example.smarthomeusagemonitor.domain.UsageLog;
import org.example.smarthomeusagemonitor.repository.ApplianceRepository;
import org.example.smarthomeusagemonitor.repository.UsageLogRepository;
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
        usageLog.setUser(appliance.getUser());

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
