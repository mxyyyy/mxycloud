package com.mxy.springcloud.order.sentinel;

import com.mxy.springcloud.order.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 47573
 * @Description openfeign远程调用的时候， 远程服务宕机，触发熔断，服务降级，将执行这里
 * @since 2020-12-24 21:25
 */
@Slf4j
@Component
public class PaymentFeignFallback implements PaymentFeign {
    @Override
    public String getPayment(Long id) {
        return "getPayment方法出错， nacos-payment-provider服务异常 可能宕机，服务降级---";
    }

    @Override
    public String testSentinel(Long id) {
        return "testSentinel方法出错 nacos-payment-provider服务异常 可能宕机，服务降级---";
    }
}
