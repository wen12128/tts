package com.tts.weixin.user;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 发送图片消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class GroupRequest implements Serializable {
    private static final long serialVersionUID = 6604252954648162881L;

    //properties
    private String touser;
    private String msgtype="image";
    private Image image;

    //constructor
    public GroupRequest() {}
    public GroupRequest(String touser, String msgtype, Image image) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.image = image;
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
    @XmlElement(name = "image")
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image implements Serializable {
        private String media_id;

        public Image() {}
        public Image(String media_id) {
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