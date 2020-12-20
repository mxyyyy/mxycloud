package com.mxy.springcloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 47573
 * @since 2020-12-20 11:08
 */
@Component
@FeignClient(value = "nacos-payment-provider")
public interface PaymentFeign {

    @GetMapping(value = "/payment/{id}")
    public String getPayment(@PathVariable("id") Long id);
}
