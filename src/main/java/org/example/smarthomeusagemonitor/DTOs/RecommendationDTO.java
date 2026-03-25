package com.example.demo.DTOs;

import com.example.demo.domain.Recommendation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RecommendationDTO {
    private Long recommendationId;
    private String message;
    private double potentialSavings;
    private LocalDate createdAt;

    public RecommendationDTO(Recommendation recommendation){
        this.recommendationId = recommendation.getRecommendationId();
        this.message = recommendation.getMessage();
        this.potentialSavings = recommendation.getPotentialSavings();
        this.createdAt = recommendation.getCreatedAt();
    }
}
