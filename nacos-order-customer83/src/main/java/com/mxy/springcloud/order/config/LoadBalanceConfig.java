package com.mxy.springcloud.order.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author 47573
 * @Description 自定义ribbon负载均衡策略
 * @since 2020-12-24 17:32
 */
@Slf4j
//@Configuration //注入到spring将生效
public class LoadBalanceConfig extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        log.info("LoadBalanceConfig.initWithNiwsConfig");
    }

    @Override
    public Server choose(Object key) {
        log.info("key:" + key);
        // getLoadBalancer().getAllServers()获取到所有的服务列表
        List<Server> allServers = getLoadBalancer().getAllServers();
        log.info(allServers.toString());
        return allServers.get(0);
    }
}
