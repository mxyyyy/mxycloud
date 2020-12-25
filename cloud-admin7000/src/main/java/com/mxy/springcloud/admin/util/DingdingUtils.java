package com.mxy.springcloud.admin.util;

import com.alibaba.fastjson.JSONObject;
import com.mxy.springcloud.admin.model.MessageInfo;
import com.mxy.springcloud.admin.model.TextMessage;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 47573
 * @Description
 * @since 2020-12-25 11:45
 */
@Slf4j
public class DingdingUtils {

    private static String webhook = "https://oapi.dingtalk.com/robot/send?access_token=cfbb4cbc89e8408e5ddbc089a0c71c9f46f163773450eda0a24bf9bbc09965aa"; //钉钉webhook

    private static OkHttpClient client = new OkHttpClient();
    /**
     * 发送钉钉消息 markdown
     * @param msg 消息内容
     * @return
     */
    public static boolean sendToDingding(String msg) {
        try{
            String type = "application/json; charset=utf-8";
            RequestBody body = RequestBody.create(MediaType.parse(type), msg);
            Request.Builder builder = new Request.Builder().url(webhook);
            builder.addHeader("Content-Type", type).post(body);
            Request request = builder.build();
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            log.info(String.format("send ding message:%s", string));
            JSONObject res = JSONObject.parseObject(string);
            return res.getIntValue("errcode") == 0;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送钉钉消息 text
     * @param msg 消息内容
     * @return
     */
    public static void sendTextToDingding(String msg) {
        try {
            TextMessage message = new TextMessage();
            message.setText(new MessageInfo(msg));
            // URL url = new URL("https://oapi.dingtalk.com/robot/send?access_token=" + access_token);
            URL url = new URL(webhook);
            // 建立 http 连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            String textMessage = JSONObject.toJSONString(message);
            byte[] data = textMessage.getBytes();
            out.write(data);
            out.flush();
            out.close();
            InputStream in = conn.getInputStream();
            byte[] data1 = new byte[in.available()];
            in.read(data1);
            log.info(new String(data1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
