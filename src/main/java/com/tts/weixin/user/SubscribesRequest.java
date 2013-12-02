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
public class SubscribesRequest implements Serializable {
    private static final long serialVersionUID = -5368382398464704353L;

    //properties
    private String subscribe;
    private String openid;
    private String nickname;//昵称
    private String sex;//性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String language;
    private String city;//所在城市
    private String province;//所在省份
    private String country;//所在国家
    private String headimgurl;//头像
    private String subscribe_time;//用户关注时间

    //constructor
    public SubscribesRequest() {}
    public SubscribesRequest(String subscribe, String openid, String nickname, String sex, String language, String city, String province, String country, String headimgurl, String subscribe_time) {
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
    }

    //Getter/Setter
    @XmlElement(name = "subscribe")
    public String getSubscribe() {
        return subscribe;
    }
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }
    @XmlElement(name = "openid")
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    @XmlElement(name = "nickname")
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @XmlElement(name = "sex")
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @XmlElement(name = "language")
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(name = "province")
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @XmlElement(name = "headimgurl")
    public String getHeadimgurl() {
        return headimgurl;
    }
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
    @XmlElement(name = "subscribe_time")
    public String getSubscribe_time() {
        return subscribe_time;
    }
    public void setSubscribe_time(String subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}