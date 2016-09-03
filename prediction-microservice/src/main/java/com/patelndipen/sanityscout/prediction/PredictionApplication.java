package com.patelndipen.sanityscout.prediction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigurationProperties
@Configuration
public class PredictionApplication {
  public static void main(String[] args) {
    SpringApplication.run(PredictionApplication.class, args);
  }
}
