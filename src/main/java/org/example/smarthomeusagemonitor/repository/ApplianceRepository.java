package org.example.smarthomeusagemonitor.repository;

import org.example.smarthomeusagemonitor.domain.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
