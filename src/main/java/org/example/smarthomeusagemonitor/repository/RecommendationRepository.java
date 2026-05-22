package org.example.smarthomeusagemonitor.repository;

import org.example.smarthomeusagemonitor.domain.Recommendation;
import org.example.smarthomeusagemonitor.domain.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findByUsageLog(UsageLog usageLog);

}
