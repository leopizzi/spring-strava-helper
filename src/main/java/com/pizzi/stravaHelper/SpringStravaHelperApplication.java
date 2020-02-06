package com.pizzi.stravaHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringStravaHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStravaHelperApplication.class, args);
    }

}
