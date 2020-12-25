package com.mxy.springcloud.order.sentinel;

import com.mxy.springcloud.order.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 47573
 * @Description 自定义降级异常， 方法报错，执行出异常等等，也就是会触发熔断 将会执行的方法
 *              sentinel服务就算没起， fallback依然可以正常执行 服务依然可以降级
 * @since 2020-12-24 19:47
 */
@Slf4j
public class CustomFallbackHandler {

    public static String fallbackHandler(Long id, Throwable e) //或者@RequestParam Long id
    {
        return "自定义降级异常， 参数"+ id +"。 Throwable:" + e;
    }
}
