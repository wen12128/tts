package com.tts.weixin;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 13-11-28
 * Time: 下午12:40
 * To change this template use File | Settings | File Templates.
 */
public interface MessageType {
  public static final String MSG_TEXT = "text";
  public static final String MSG_IMAGE = "image";
  public static final String MSG_VOICE = "voice";
  public static final String MSG_VIDEO = "video";
  public static final String MSG_LOCATION = "location";
  public static final String MSG_LINK = "link";
  public static final String MSG_EVENT = "event";
  public static final String MSG_EVENT_SUBSCRIBE = "subscribe";
  public static final String MSG_EVENT_UNSUBSCRIBE = "unsubscribe";
  public static final String MSG_EVENT_SCAN = "scan";
  public static final String MSG_EVENT_LOCATION = "LOCATION";
  public static final String MSG_EVENT_MENU = "CLICK";
}
