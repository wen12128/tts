package com.tts.weixin.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 回复视频消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class MusicMessageResponse implements Serializable {
    private static final long serialVersionUID = 8650794115866017994L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="video";
    private Video video;

    //constructor
    public MusicMessageResponse() {}
    public MusicMessageResponse(String toUserName, String fromUserName, String createTime, String msgType, Video video) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.video = video;
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
    @XmlElement(name = "Video")
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }

    private static class Video implements Serializable {
        private static final long serialVersionUID = -6640187987771068052L;
        private String mediaId;
        private String thumbMediaId;

        private Video() {}
        private Video(String mediaId, String thumbMediaId) {
            this.mediaId = mediaId;
            this.thumbMediaId = thumbMediaId;
        }

        @XmlElement(name = "MediaId")
        public String getMediaId() {
            return mediaId;
        }
        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
        @XmlElement(name = "ThumbMediaId")
        public String getThumbMediaId() {
            return thumbMediaId;
        }
        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
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