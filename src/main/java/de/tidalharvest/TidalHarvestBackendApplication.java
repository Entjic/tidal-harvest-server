package de.tidalharvest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TidalHarvestBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TidalHarvestBackendApplication.class, args);
    }


}
