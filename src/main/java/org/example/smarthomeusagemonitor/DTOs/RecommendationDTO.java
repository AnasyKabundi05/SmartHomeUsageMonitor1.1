package org.example.smarthomeusagemonitor.DTOs;

import org.example.smarthomeusagemonitor.domain.Recommendation;
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

    public RecommendationDTO(Recommendation rec) {
        this.recommendationId = rec.getRecommendationId();
        this.message = rec.getMessage();
        this.potentialSavings = rec.getPotentialSavings();
    }
}
