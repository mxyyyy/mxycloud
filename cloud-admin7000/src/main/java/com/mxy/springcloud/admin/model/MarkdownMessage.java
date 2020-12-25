package com.mxy.springcloud.admin.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 47573
 * @Description markdown 内容
 * @since 2020-12-25 11:50
 */
public class MarkdownMessage {

    private String msgtype;

    // 显示标题
    private String title;

    // 显示内容
    private String content;

    // 是否at所有人
    private Boolean isAtAll;

    // 被@人的手机号(在content里添加@人的手机号)
    private List<String> atMobiles;


    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsAtAll() {
        return isAtAll;
    }

    public void setIsAtAll(Boolean isAtAll) {
        this.isAtAll = isAtAll;
    }

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public String getMsgtype() {
        return "markdown";
    }

    public String getJSONObjectString() {
        // markdown类型
        JSONObject markdownContent = new JSONObject();
        markdownContent.put("title", getTitle());
        markdownContent.put("text", getContent());

        // at some body
        JSONObject atMobile = new JSONObject();
        if(getAtMobiles().size() > 0){
            List<String> mobiles = new ArrayList<String>();
            for (int i=0;i<getAtMobiles().size();i++){
                mobiles.add(getAtMobiles().get(i));
            }
            if(mobiles.size()>0){
                atMobile.put("atMobiles", mobiles);
            }
            atMobile.put("isAtAll", getIsAtAll());
        }

        JSONObject json = new JSONObject();
        json.put("msgtype", getMsgtype());
        json.put("markdown", markdownContent);
        json.put("at", atMobile);
        return json.toJSONString();
    }
}
