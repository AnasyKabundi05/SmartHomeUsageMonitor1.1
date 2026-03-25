package com.example.demo.repository;

import com.example.demo.domain.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {

}
