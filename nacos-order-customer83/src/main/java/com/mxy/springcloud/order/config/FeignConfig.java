package com.mxy.springcloud.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 47573
 * @since 2020-12-20 11:19
 * 打印feign调用日志
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level FeignLogLevel(){
        return Logger.Level.FULL;
    }
}
