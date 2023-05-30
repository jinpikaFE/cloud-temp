package com.jinpika.temp.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jinpika.temp.ums.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class TempUmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempUmsApplication.class, args);
	}

}
