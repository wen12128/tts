package com.tts.weixin.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 接收消息-语音消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class VoiceMessageResponse implements Serializable {
    private static final long serialVersionUID = -3032064319420578340L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="voice";
    private String format;
    private String mediaId;
    private String msgId;

    //constructor
    public VoiceMessageResponse() {}
    public VoiceMessageResponse(String toUserName, String fromUserName, String createTime, String msgType, String format, String mediaId, String msgId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.format = format;
        this.mediaId = mediaId;
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
    @XmlElement(name = "Format")
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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