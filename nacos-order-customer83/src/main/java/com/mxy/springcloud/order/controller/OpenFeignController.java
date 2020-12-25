package com.mxy.springcloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mxy.springcloud.order.feign.PaymentFeign;
import com.mxy.springcloud.order.sentinel.CustomBlockHandler;
import com.mxy.springcloud.order.sentinel.CustomFallbackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类注释
 *
 * @author 47573
 * @since 2020-12-20 11:06
 */
@RestController
@Slf4j
public class OpenFeignController {

    @Autowired
    PaymentFeign paymentFeign;

    @GetMapping("/order1/{id}")
    public String order1(@PathVariable Long id) {
        log.info("=========order1 -> openFeign========");

       return paymentFeign.getPayment(id);
    }

    // 测试流控和降级
    @GetMapping("/order/testSentinel")
    @SentinelResource(value = "a",
            blockHandlerClass= CustomBlockHandler.class,
            blockHandler="handlerException",
            fallbackClass= CustomFallbackHandler.class,
            fallback="fallbackHandler")
    public String testSentinel(@RequestParam Long id) {
        log.info("=========testSentinel========");
        if (id == 2) {
            System.out.println(1/0); // 触发fallback
        }
        return paymentFeign.testSentinel(id);
    }
}
