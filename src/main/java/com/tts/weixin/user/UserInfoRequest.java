package com.tts.weixin.user;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 查询分组.
 * User: eric
 * Date: 13-11-23
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class UserInfoRequest implements Serializable {
    private static final long serialVersionUID = -38089142533517866L;

    //properties
    private String id;
    private String name;
    private String count;

    //constructor
    public UserInfoRequest() {}
    public UserInfoRequest(String id, String name, String count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    //Getter/Setter
    @XmlElement(name = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "count")
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}