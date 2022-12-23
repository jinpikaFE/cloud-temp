package com.jinpika.temp.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jinpika.temp.product.pms.mapper")
@SpringBootApplication
public class TempProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempProductApplication.class, args);
    }

}
