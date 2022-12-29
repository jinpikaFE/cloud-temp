package com.jinpika.temp.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TempThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempThirdPartyApplication.class, args);
    }

}
