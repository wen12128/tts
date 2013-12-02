package com.tts.weixin.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 发送语音消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class SendVideoMessageRequest implements Serializable {
    private static final long serialVersionUID = 5288928634623114156L;

    //properties
    private String touser;
    private String msgtype="voice";
    private Voice voice;

    //constructor
    public SendVideoMessageRequest() {}
    public SendVideoMessageRequest(String touser, String msgtype, Voice voice) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.voice = voice;
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
    @XmlElement(name = "voice")
    public Voice getVoice() {
        return voice;
    }
    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public static class Voice implements Serializable {
        private String media_id;

        public Voice() {}
        public Voice(String media_id) {
            this.media_id = media_id;
        }

        @XmlElement(name = "media_id")
        public String getMedia_id() {
            return media_id;
        }
        public void setMedia_id(String media_id) {
            this.media_id = media_id;
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