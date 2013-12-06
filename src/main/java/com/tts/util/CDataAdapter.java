package com.tts.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * CDATA.
 * User: eric
 * Date: 13-12-4
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class CDataAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return String.format("<![CDATA[%s]]>",v);
    }
}