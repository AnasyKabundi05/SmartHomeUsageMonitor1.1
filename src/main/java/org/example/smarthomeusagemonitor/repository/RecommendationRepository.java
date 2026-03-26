package org.example.smarthomeusagemonitor.repository;

import org.example.smarthomeusagemonitor.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}
