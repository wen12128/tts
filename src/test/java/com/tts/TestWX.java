package com.tts;

import com.tts.util.DateUtils;
import com.tts.util.NumberUtil;
import com.tts.util.WXUtils;
import com.tts.util.XmlHelper;
import com.tts.weixin.MessageType;
import com.tts.weixin.request.TextMessageRequest;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 13-11-23
 * Time: 下午12:41
 * To change this template use File | Settings | File Templates.
 */
public class TestWX {
    @Test
    public void testText() {
        TextMessageRequest text = new TextMessageRequest("wen12128","wen121281",DateUtils.getTimestamp(),"this is test",NumberUtil.randomNums(1000));
        String xml = WXUtils.toXmlByObject("UTF-8", text);
        System.out.printf("text request:\n"+xml);
    }
}
