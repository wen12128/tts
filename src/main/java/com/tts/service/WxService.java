package com.tts.service;

import com.tts.util.DateUtils;
import com.tts.util.WXUtils;
import com.tts.util.XmlHelper;
import com.tts.weixin.MessageType;
import com.tts.weixin.request.TextMessageRequest;
import com.tts.weixin.response.TextMessageResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * WX.
 * User: eric
 * Date: 13-12-4
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 */
@Service("wxService")
public class WxService implements IWXService {
    private static Logger logger = LoggerFactory.getLogger(WxService.class);

    public String messageHandler(String xml) {
        String result = "";

        if (StringUtils.isNotBlank(xml)) {
            String type = XmlHelper.getMessageType(xml);
            if (MessageType.MSG_TEXT.equals(type)) {
                TextMessageRequest text = WXUtils.toObjectByXml(xml, TextMessageRequest.class);
                //TextMessageResponse reply = new TextMessageResponse(XmlHelper.toXml(text.getFromUserName()),XmlHelper.toXml(MP), DateUtils.getTimestamp(),XmlHelper.toXml(text.getFromUserName()+":"+text.getContent()),"0");
                TextMessageResponse reply = new TextMessageResponse(text.getFromUserName(),MP, DateUtils.getTimestamp(),text.getFromUserName()+":"+text.getContent());
                result = WXUtils.toXmlByObject("UTF-8",reply);
            } else if (MessageType.MSG_IMAGE.equals(type)) {

            } else if (MessageType.MSG_VOICE.equals(type)) {

            } else if (MessageType.MSG_VIDEO.equals(type)) {

            } else if (MessageType.MSG_LOCATION.equals(type)) {

            } else if (MessageType.MSG_LINK.equals(type)) {

            } else if (MessageType.MSG_EVENT.equals(type)) {

            } else {

            }
        }
        logger.info("reply message:\n"+result+"\n");
        return result;
    }
}