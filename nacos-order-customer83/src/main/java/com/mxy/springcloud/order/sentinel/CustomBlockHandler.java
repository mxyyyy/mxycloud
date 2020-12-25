package com.mxy.springcloud.order.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 47573
 * @Description 自定义限流异常， 流量访问被sentinel达到规则限制将会执行
 * @since 2020-12-24 19:47
 */
@Slf4j
public class CustomBlockHandler {

    public static String handlerException(Long id, BlockException e) {//或者@RequestParam Long id
        return "自定义限流异常， 参数"+ id +" 。BlockException:" + e;
    }
}
