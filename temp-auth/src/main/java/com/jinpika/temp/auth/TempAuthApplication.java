package com.jinpika.temp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jinpika.temp.auth.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class TempAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempAuthApplication.class, args);
    }

}
