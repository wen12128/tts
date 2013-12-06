package com.tts.util;

import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlHelper
{
  public static Element assertXmlBy(String xml, String node)
  {
    Document doc = null;
    try {
      doc = DocumentHelper.parseText(xml);
    } catch (DocumentException e) {
      e.printStackTrace();
    }

    Element root = doc.getRootElement();
    Element serviceName = (Element)doc.selectSingleNode(node);

    return serviceName;
  }

    public static String toXml(String text)
    {
        return String.format("<![CDATA[%s]]>",text);
    }

  public static String toXml2(String text)
  {
    return "<![CDATA[" + text + "]]>";
  }

  public static String trimXml(String xml) {
    return RegexUtil.match(xml, "\\<!\\[CDATA\\[(*)\\]\\]\\>", 1);
  }

  public static String getMessageType(String xml) {
    return RegexUtil.match(xml, "\\<MsgType\\>\\<!\\[CDATA\\[(.*?)\\]\\]\\>\\</MsgType\\>", 1);
  }

  public static String getEvent(String xml) {
    return RegexUtil.match(xml, "\\<Event\\>\\<!\\[CDATA\\[(.*?)\\]\\]\\>\\</Event\\>", 1);
  }

  public static Map<String, String> getError(String xml) {
    return RegexUtil.matchError(xml, "\\{\\\"errcode\\\":(.*?),\\\"errmsg\\\":(.*?)\\}", 1, 2);
  }

  public static String getAccessToken(String xml) {
    return RegexUtil.matchToken(xml, "\\{\\\"access_token\\\":(.*?),\\\"expires_in\\\":(.*?)\\}", 1);
  }

  public static boolean isRQ(String xml)
  {
    return RegexUtil.validateType(xml, "\\<EventKey\\>\\<!\\[CDATA\\[qrscene_(.*?)\\]\\]\\>\\</EventKey\\>");
  }

  public static boolean isRecognition(String xml)
  {
    return RegexUtil.validateType(xml, "\\<Recognition\\>\\<!\\[CDATA\\[(.*?)\\]\\]\\>\\</Recognition\\>");
  }
}
