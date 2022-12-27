package com.jinpika.temp.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.jinpika.temp.member.feign")
@EnableDiscoveryClient
public class TempMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempMemberApplication.class, args);
    }

}
