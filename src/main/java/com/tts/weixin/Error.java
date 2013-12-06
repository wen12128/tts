package com.tts.weixin;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement
public class Error
  implements Serializable
{
  private static final long serialVersionUID = 4997526196564984326L;
  private String errcode;
  private String errmsg;

  public Error()
  {
  }

  public Error(String errcode, String errmsg)
  {
    this.errcode = errcode;
    this.errmsg = errmsg;
  }

  @XmlElement(name="errcode")
  public String getErrcode()
  {
    return this.errcode;
  }
  public void setErrcode(String errcode) {
    this.errcode = errcode;
  }
  @XmlElement(name="errmsg")
  public String getErrmsg() {
    return this.errmsg;
  }
  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this);
  }
}
