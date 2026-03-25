package com.example.demo.repository;

import com.example.demo.domain.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
