package com.reptile.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LagouMainApplication {
    public static void main( String[] args ){
        SpringApplication.run(LagouMainApplication.class, args);
    }
}
