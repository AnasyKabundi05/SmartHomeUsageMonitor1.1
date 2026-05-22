package org.example.smarthomeusagemonitor.service;

import org.example.smarthomeusagemonitor.domain.Recommendation;
import org.example.smarthomeusagemonitor.domain.UsageLog;
import org.example.smarthomeusagemonitor.repository.RecommendationRepository;
import org.example.smarthomeusagemonitor.repository.UsageLogRepository;
import org.example.smarthomeusagemonitor.DTOs.RecommendationDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UsageLogRepository usageLogRepository;

    public RecommendationService(RecommendationRepository recommendationRepository, UsageLogRepository usageLogRepository) {
        this.recommendationRepository = recommendationRepository;
        this.usageLogRepository = usageLogRepository;
    }

    public List<Recommendation> getAllRecommendations(){
        return recommendationRepository.findAll();
    }

    public Recommendation createRecommendation(Long usageLogId) {

        UsageLog usageLog = usageLogRepository.findById(usageLogId)
                .orElseThrow(() -> new RuntimeException("UsageLog not found"));

        Recommendation recommendation = new Recommendation();

        double kWh = usageLog.getCalculatedKwh();

        if (kWh < 100) {
            recommendation.setMessage("Very low usage; normal appliance activity is fine");
        } else if (kWh <= 500) {
            recommendation.setMessage("Maintain the usage at this level to see no significant increases in cost and energy consumption");
        } else if (kWh <= 750) {
            recommendation.setMessage("Unplug or Turn Off Standby Devices");
        } else if (kWh <= 1500) {
            recommendation.setMessage("I suggest keeping the energy consumption at its current level");
        } else {
            recommendation.setMessage("High consumption! Reduce appliance usage immediately");
        }

        recommendation.setUsageLog(usageLog);
        recommendation.setCreatedAt(LocalDate.now());
        recommendation.setAppliance(usageLog.getAppliance());

        return recommendationRepository.save(recommendation);
    }

    public List<RecommendationDTO> getRecommendationsByUsageLog(Long usageLogId) {
        UsageLog log = usageLogRepository.findById(usageLogId)
                .orElseThrow(() -> new RuntimeException("Usage log not found"));

        return recommendationRepository.findByUsageLog(log)
                .stream()
                .map(RecommendationDTO::new)
                .toList();
    }

    public void deleteRecommendationById(Long recommendationId){
        recommendationRepository.deleteById(recommendationId);
    }
}
