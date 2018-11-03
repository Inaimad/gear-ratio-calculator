package com.gearcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.gearcalc")
@EnableJpaRepositories(basePackages = "com.gearcalc.repositories")
@EntityScan(basePackages = "com.gearcalc.entities")
public class GearRatioCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GearRatioCalculatorApplication.class, args);
    }


}
