package com.tts.weixin.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 扫描带参数二维码事件.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * 1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * 2.如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
 */
@XmlRootElement(name = "xml")
public class RQEvent implements Serializable {
    private static final long serialVersionUID = 1843493077239213823L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="event";
    private String event;//subscribe(未关注)、scan(已关注)
    private String eventKey;//qrscene_为前缀，后面为二维码的参数值(未关注)、一个32位无符号整数(已关注)
    private String ticket;//二维码的ticket，可用来换取二维码图片

    //constructor
    public RQEvent() {}
    public RQEvent(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey, String ticket) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
        this.eventKey = eventKey;
        this.ticket = ticket;
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
    @XmlElement(name = "Ticket")
    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}