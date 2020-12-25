package com.mxy.springcloud.admin.baojing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.mxy.springcloud.admin.model.MarkdownMessage;
import com.mxy.springcloud.admin.util.DingdingUtils;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author 47573
 * @Description 发送 text类型的消息
 * @since 2020-12-24 22:27
 */
@Component
public class DingDingNotifier extends AbstractStatusChangeNotifier {

    public DingDingNotifier(InstanceRepository repository) {
        super(repository);
    }
    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        String serviceName = instance.getRegistration().getName();
        String serviceUrl = instance.getRegistration().getServiceUrl();
        String status = instance.getStatusInfo().getStatus();
        Map<String, Object> details = instance.getStatusInfo().getDetails();
        StringBuilder str = new StringBuilder();
        str.append(" 监控报警 :【"+ serviceName + "】\n");
        str.append("【服务地址】 " + serviceUrl + "\n");
        str.append("【状态】 " + status + "\n");
        str.append("【详情】 " + JSONObject.toJSONString(details));

        // 发送 markdown格式
//        MarkdownMessage markdownMessage = new MarkdownMessage();
//        markdownMessage.setTitle("# 监控报警");
//        markdownMessage.setContent("# 监控报警 :【"+ serviceName + "】\n #### 杭州天气 @xxx\n > 9度，西北风1级，空气良89，相对温度73%\n\n > ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\n > ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n **<font color=red>红色-加粗</font>**");
//        markdownMessage.setIsAtAll(true);
//        markdownMessage.setAtMobiles(new ArrayList<>(Arrays.asList("18182736664")));
        return Mono.fromRunnable(() -> {
            DingdingUtils.sendTextToDingding(str.toString());
//            DingdingUtils.sendToDingding(markdownMessage.getJSONObjectString());
        });
    }

}