package com.tts.service;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 13-12-4
 * Time: 下午1:14
 * To change this template use File | Settings | File Templates.
 */
public interface IWXService {
    //public final String TOKEN = "wxt";
    public final String URL = "http://wsd.ap01.aws.af.cm/wx/";
    public final String MP = "wen12128";

    public String messageHandler(String xml);
}