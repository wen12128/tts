package com.tts.weixin.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 发送视频消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class SendMusicMessageRequest implements Serializable {
    //properties
    private String touser;
    private String msgtype="video";
    private Video video;

    //constructor
    public SendMusicMessageRequest() {}
    public SendMusicMessageRequest(String touser, String msgtype, Video video) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.video = video;
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
    @XmlElement(name = "video")
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }

    public static class Video implements Serializable {
        private String media_id;
        private String thumb_media_id;

        public Video() {}
        public Video(String media_id, String thumb_media_id) {
            this.media_id = media_id;
            this.thumb_media_id = thumb_media_id;
        }

        @XmlElement(name = "media_id")
        public String getMedia_id() {
            return media_id;
        }
        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
        @XmlElement(name = "thumb_media_id")
        public String getThumb_media_id() {
            return thumb_media_id;
        }
        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
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