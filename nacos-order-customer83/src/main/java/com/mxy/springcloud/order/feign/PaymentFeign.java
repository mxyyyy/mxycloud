package com.mxy.springcloud.order.feign;

import com.mxy.springcloud.order.sentinel.PaymentFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 47573
 * @since 2020-12-20 11:08
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFeignFallback.class)
public interface PaymentFeign {

    @GetMapping(value = "/payment/{id}")
    public String getPayment(@PathVariable("id") Long id);

    // 流控和降级
    @GetMapping(value = "/payment/testSentinel")
    public String testSentinel(@RequestParam("id") Long id);
}
