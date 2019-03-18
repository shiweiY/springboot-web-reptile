package com.boss.reptile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BOSSMainController {
    public static void main( String[] args ){
    	SpringApplication.run(BOSSMainController.class, args);
    }
}
