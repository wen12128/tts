package com.tts.weixin.menu;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 错误.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class MenuCreateRequest implements Serializable {
    private static final long serialVersionUID = 4997526196564984326L;

    //properties
    private String errcode;
    private String errmsg;

    //constructor
    public MenuCreateRequest() {}
    public MenuCreateRequest(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    //Getter/Setter
    @XmlElement(name = "errcode")
    public String getErrcode() {
        return errcode;
    }
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    @XmlElement(name = "errmsg")
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}