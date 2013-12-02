package com.tts.weixin.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 发送文本消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class SendNewsMessageRequest implements Serializable {
    private static final long serialVersionUID = -2314309295742683750L;

    //properties
    private String touser;
    private String msgtype="text";
    private Text text;

    //constructor
    public SendNewsMessageRequest() {}
    public SendNewsMessageRequest(String touser, String msgtype, Text text) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.text = text;
    }

    //Getter/Setter
    @XmlElement(name = "touser")
    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }
    @XmlElement(name = "msgtype")
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    @XmlElement(name = "text")
    public Text getText() {
        return text;
    }
    public void setText(Text text) {
        this.text = text;
    }

    public static class Text implements Serializable {
        private static final long serialVersionUID = -342212119565796950L;

        private String context;

        public Text() {}
        public Text(String context) {
            this.context = context;
        }

        @XmlElement(name = "content")
        public String getContext() {
            return context;
        }
        public void setContext(String context) {
            this.context = context;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}