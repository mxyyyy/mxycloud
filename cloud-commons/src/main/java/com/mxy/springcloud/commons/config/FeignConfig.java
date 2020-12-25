package com.mxy.springcloud.commons.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 47573
 * @since 2020-12-24 15:29
 *  @Description 服务间调用的时候可以加上token，token就这样在服务间传递
 */
@Configuration
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //添加token, Authorization是token的key
        requestTemplate.header("Authorization", request.getHeader("Authorization"));

    }
}
