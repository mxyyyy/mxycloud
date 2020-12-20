package com.mxy.springcloud.order.controller;

import com.mxy.springcloud.order.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类注释
 *
 * @author 47573
 * @since 2020-12-20 11:06
 */
@RestController
@Slf4j
public class OpenFeighController {

    @Autowired
    PaymentFeign paymentFeign;

    @GetMapping("/order1/{id}")
    public String order1(@PathVariable Long id) {
        log.info("=========order1 -> openFeign========");
       return paymentFeign.getPayment(id);
    }
}
