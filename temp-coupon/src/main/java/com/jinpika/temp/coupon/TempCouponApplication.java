package com.jinpika.temp.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TempCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempCouponApplication.class, args);
	}

}
