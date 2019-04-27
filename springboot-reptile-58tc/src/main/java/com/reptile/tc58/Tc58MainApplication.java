package com.reptile.tc58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Tc58MainApplication {
    public static void main( String[] args ){
        SpringApplication.run(Tc58MainApplication.class, args);
    }
}
