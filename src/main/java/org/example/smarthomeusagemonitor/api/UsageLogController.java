package org.example.smarthomeusagemonitor.api;

import org.example.smarthomeusagemonitor.DTOs.UsageLogDTO;
import org.example.smarthomeusagemonitor.domain.UsageLog;
import org.example.smarthomeusagemonitor.service.UsageLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://35.172.27.21")
@RequestMapping("/api/usageLog")
public class UsageLogController {

    private final UsageLogService usageLogService;

    public UsageLogController(UsageLogService usageLogService) {
        this.usageLogService = usageLogService;
    }

    @GetMapping
    public List<UsageLog> getAllUsageLogs(){
        return usageLogService.getAllUsageLogs();
    }

    @PostMapping("/appliance/{applianceId}")
    public UsageLog createUsageLog(@PathVariable Long applianceId, @RequestBody UsageLogDTO request){
        return usageLogService.createUsageLog(applianceId,request);
    }

    @GetMapping("/{usageLogId}")
    public UsageLog getUsageLogById(@PathVariable Long usageLogId){
        return usageLogService.getUsageLogById(usageLogId);
    }

    @DeleteMapping("/{usageLogId}")
    public void deleteUsageLogById(@PathVariable Long usageLogId){
        usageLogService.deleteUsageLogById(usageLogId);
    }


}
