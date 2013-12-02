package com.tts.weixin.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 语音识别结果.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class SpeechRecognitionRequest implements Serializable {
    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="voice";
    private String mediaId;
    private String format;
    private String recognition;
    private String msgId;

    //constructor
    public SpeechRecognitionRequest() {}
    public SpeechRecognitionRequest(String toUserName, String fromUserName, String createTime, String msgType, String mediaId, String format, String recognition, String msgId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.mediaId = mediaId;
        this.format = format;
        this.recognition = recognition;
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
    @XmlElement(name = "MsgId")
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    @XmlElement(name = "Format")
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    @XmlElement(name = "Recognition")
    public String getRecognition() {
        return recognition;
    }
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}