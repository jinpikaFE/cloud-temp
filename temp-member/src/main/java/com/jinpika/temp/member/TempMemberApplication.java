package com.jinpika.temp.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TempMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempMemberApplication.class, args);
    }

}
