package org.example.smarthomeusagemonitor.api;

import org.example.smarthomeusagemonitor.DTOs.RecommendationDTO;
import org.example.smarthomeusagemonitor.domain.Recommendation;
import org.example.smarthomeusagemonitor.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public List<Recommendation> getAllRecommendations(){
        return recommendationService.getAllRecommendations();
    }

    @PostMapping("/usage/{usageLogId}")
    public Recommendation createRecommendation(@PathVariable Long usageLogId){
        return recommendationService.createRecommendation(usageLogId);
    }

    @GetMapping("/usage/{usageLogId}")
    public List<RecommendationDTO> getRecommendationsByUsageLog(@PathVariable Long usageLogId) {
        return recommendationService.getRecommendationsByUsageLog(usageLogId);
    }

    @DeleteMapping("/{recommendationId}")
    public void deleteRecommendationById(@PathVariable Long recommendationId){
        recommendationService.deleteRecommendationById(recommendationId);
    }
}

