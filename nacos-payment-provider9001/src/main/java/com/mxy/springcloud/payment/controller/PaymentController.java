package com.mxy.springcloud.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类注释
 *
 * @author 47573
 * @since 2020-12-18 11:55
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @GetMapping(value = "/payment/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "nacos registry, serverPort: " + port + "\t id :" + id;
    }

    @GetMapping(value = "/payment/testSentinel")
    public String testSentinel(@RequestParam Long id) {
        return "/payment/test， testSentinel, serverPort: " + port + "\t id :" + id;
    }
}
