package com.MyTrailerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // This annotation turns this application into a Eureka Server
public class MyTrailerApp {
    public static void main(String[] args) {
        SpringApplication.run(MyTrailerApp.class, args);
    }
}
