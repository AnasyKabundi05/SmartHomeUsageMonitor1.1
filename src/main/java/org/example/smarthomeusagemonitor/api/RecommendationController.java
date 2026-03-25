package com.example.demo.api;

import com.example.demo.domain.Recommendation;
import com.example.demo.service.RecommendationService;
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

    @PostMapping("/{usageLogId}")
    public Recommendation createRecommendation(@PathVariable Long usageLogId){
        return recommendationService.createRecommendation(usageLogId);
    }

    @DeleteMapping("/{recommendationId}")
    public void deleteRecommendationById(@PathVariable Long recommendationId){
        recommendationService.deleteRecommendationById(recommendationId);
    }
}
