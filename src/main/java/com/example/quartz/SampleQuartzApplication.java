package com.example.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:schedules.properties")
public class SampleQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleQuartzApplication.class, args);
    }

}

