package com.mxy.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 类注释
 * @author 47573
 * @since 2020-12-18 15:03
 */
@RestController
@Slf4j
@RefreshScope // 保证动态刷新nacos配置，实现配置自动更新
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-service}")
    private String serverName;

    /*
     为什么可以负载均衡？
     spring-cloud-starter-alibaba-nacos-discovery 整合了rabbon， rabbon又有restTemplate， 自带的是轮询
     */
    @GetMapping("/order/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        String ret = restTemplate.getForObject(serverName + "/payment/" + id, String.class);
        return ret;
    }


    @Value("${version}")
    private String version;

    /*
     * @Author: mxy
     * @Date: 2020/12/18 17:17
     * @Param: []
     * @Return: java.lang.String
     * @Description: 测试自动刷新
    */
    @GetMapping("/order/version")
    public String version() {
        return version;
    }
}
