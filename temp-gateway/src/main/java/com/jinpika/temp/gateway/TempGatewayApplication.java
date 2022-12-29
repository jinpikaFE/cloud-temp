package com.jinpika.temp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TempGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempGatewayApplication.class, args);
    }

}
