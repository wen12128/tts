package com.tts.weixin.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 接收消息-地理位置消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class LocationMessageRequest implements Serializable {
    private static final long serialVersionUID = 9139568243701683349L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="location";
    private String locationX;
    private String locationY;
    private String scale;
    private String label;
    private String msgId;

    //constructor
    public LocationMessageRequest() {}
    public LocationMessageRequest(String toUserName, String fromUserName, String createTime, String msgType, String locationX, String locationY, String scale, String label, String msgId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
        this.msgId = msgId;
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
    @XmlElement(name = "Location_X")
    public String getLocationX() {
        return locationX;
    }
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }
    @XmlElement(name = "Location_Y")
    public String getLocationY() {
        return locationY;
    }
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }
    @XmlElement(name = "Scale")
    public String getScale() {
        return scale;
    }
    public void setScale(String scale) {
        this.scale = scale;
    }
    @XmlElement(name = "Label")
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    @XmlElement(name = "MsgId")
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}