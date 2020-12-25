package com.mxy.springcloud.admin.model;

import lombok.Data;

/**
 * @author 47573
 * @Description
 * @since 2020-12-25 14:25
 */
@Data
public class TextMessage {

    private String msgtype;
    private MessageInfo text;


    public String getMsgtype() {
        return "text";
    }
    public void setMsgtype(String msgType) {
        this.msgtype = msgtype;
    }

    public MessageInfo getText() {
        return text;
    }
    public void setText(MessageInfo text) {
        this.text = text;
    }

}
