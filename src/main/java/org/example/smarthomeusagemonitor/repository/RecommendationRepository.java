package com.example.demo.repository;

import com.example.demo.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}
