package com.example.demo.api;

import com.example.demo.DTOs.UsageLogDTO;
import com.example.demo.domain.UsageLog;
import com.example.demo.service.UsageLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
