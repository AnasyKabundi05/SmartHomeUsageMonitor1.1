package org.example.smarthomeusagemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.smarthomeusagemonitor")
public class SmartHomeUsageMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartHomeUsageMonitorApplication.class, args);
    }

}
