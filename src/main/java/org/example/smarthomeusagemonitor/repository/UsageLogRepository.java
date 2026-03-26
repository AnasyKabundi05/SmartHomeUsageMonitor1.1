package org.example.smarthomeusagemonitor.repository;

import org.example.smarthomeusagemonitor.domain.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {

}
