package com.tts.weixin.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 上报地理位置事件.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class LocationEvent implements Serializable {
    private static final long serialVersionUID = 1216315431188412303L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="event";
    private String event="LOCATION";
    private String latitude;//地理位置纬度
    private String longitude;//地理位置经度
    private String precision;//地理位置精度

    //constructor
    public LocationEvent() {}
    public LocationEvent(String toUserName, String fromUserName, String createTime, String msgType, String event, String latitude, String longitude, String precision) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
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
    @XmlElement(name = "Latitude")
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    @XmlElement(name = "Longitude")
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    @XmlElement(name = "Precision")
    public String getPrecision() {
        return precision;
    }
    public void setPrecision(String precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}