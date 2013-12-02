package com.tts.weixin.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 自定义菜单事件.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class MenuEvent implements Serializable {
    private static final long serialVersionUID = -4410375671169799815L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="event";
    private String event="CLICK";
    private String eventKey;//与自定义菜单接口中KEY值对应

    //constructor
    public MenuEvent() {}
    public MenuEvent(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
        this.eventKey = eventKey;
    }

    //Getter/Setter
    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    @XmlElement(name = "CreateTime")
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    @XmlElement(name = "Event")
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}