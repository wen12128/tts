package com.tts.weixin.response;

import com.tts.util.CDataAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * 接收消息-文本消息.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "xml")
public class TextMessageResponse implements Serializable {
    private static final long serialVersionUID = 5170617044280928249L;

    //properties
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType="text";
    private String content;
    //private String funcFlag;
    //@XmlTransient private int wireless;//无线

    //constructor
    public TextMessageResponse() {}
    public TextMessageResponse(String toUserName, String fromUserName, String createTime, String content) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.content = content;
    }

    //Getter/Setter
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlJavaTypeAdapter(CDataAdapter.class)
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
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}