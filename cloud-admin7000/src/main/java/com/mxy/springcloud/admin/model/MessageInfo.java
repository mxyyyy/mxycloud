package com.mxy.springcloud.admin.model;

/**
 * @author 47573
 * @Description
 * @since 2020-12-25 14:53
 */
public class MessageInfo {
    private String content;
    public MessageInfo(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
