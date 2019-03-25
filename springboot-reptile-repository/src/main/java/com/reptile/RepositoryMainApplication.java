package com.reptile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RepositoryMainApplication {
    public static void main( String[] args ){
    	SpringApplication.run(RepositoryMainApplication.class, args);
    }
}
