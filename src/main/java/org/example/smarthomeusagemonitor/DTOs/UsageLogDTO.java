package org.example.smarthomeusagemonitor.DTOs;

import org.example.smarthomeusagemonitor.domain.UsageLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsageLogDTO {

    private Long usageLogId;
    private Long userId;
    private Long applianceId;
    private double hoursUsed;
    private LocalDate date;
    private double calculatedKwh;
    private double calculatedCost;

    public UsageLogDTO(UsageLog usageLog){
        this.usageLogId = usageLog.getUsageLogId();
        this.userId = usageLog.getUser().getUserId();
        this.applianceId = usageLog.getAppliance().getApplianceId();
        this.hoursUsed = usageLog.getHoursUsed();
        this.date = usageLog.getDate();
        this.calculatedCost = usageLog.getCalculatedCost();
        this.calculatedKwh = usageLog.getCalculatedKwh();
    }
}
