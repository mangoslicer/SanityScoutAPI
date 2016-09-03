package com.patelndipen.sanityscout.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigurationProperties
@Configuration
public class LocationApplication {
  public static void main(String[] args) {
    SpringApplication.run(LocationApplication.class, args);
  }
}
