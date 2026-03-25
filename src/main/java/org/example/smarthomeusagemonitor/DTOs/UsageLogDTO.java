package com.example.demo.DTOs;

import com.example.demo.domain.UsageLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsageLogDTO {
    private Long usageId;
    private double hoursUsed;
    private LocalDate date;
    private double calculatedKwh;
    private double calculatedCost;

    public UsageLogDTO(UsageLog usageLog){
        this.usageId = usageLog.getUsageLogId();
        this.hoursUsed = usageLog.getHoursUsed();
        this.date = usageLog.getDate();
        this.calculatedCost = usageLog.getCalculatedCost();
        this.calculatedKwh = usageLog.getCalculatedKwh();
    }
}
