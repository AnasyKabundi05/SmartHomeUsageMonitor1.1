package com.example.demo.service;

import com.example.demo.domain.Recommendation;
import com.example.demo.domain.UsageLog;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UsageLogRepository;
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

    public Recommendation createRecommendation(Long usageLogId){

        UsageLog usageLog = usageLogRepository.findById(usageLogId).orElseThrow(() -> new RuntimeException("UsageLog not found"));

        Recommendation recommendation = new Recommendation();

        double kWh = usageLog.getCalculatedKwh();

        if (kWh < 100) {
            recommendation.setMessage("Very low usage; normal appliance activity is fine");
        } else if (kWh <= 500){
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

    public void deleteRecommendationById(Long recommendationId){
        recommendationRepository.deleteById(recommendationId);
    }
}
