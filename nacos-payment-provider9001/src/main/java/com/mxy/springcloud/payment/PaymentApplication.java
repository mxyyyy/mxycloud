package com.mxy.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类注释
 *
 * @author 47573
 * @since 2020-12-18 11:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {

    public static void main(String[] args) {

        SpringApplication.run(PaymentApplication.class, args);
    }
}
