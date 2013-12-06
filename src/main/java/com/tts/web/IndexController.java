package com.tts.web;

import com.tts.service.IWXService;
import com.tts.util.WXUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * WX.
 * User: eric
 * Date: 13-12-3
 * Time: 下午3:53
 * http://www.apiwx.com/
 * http://www.weixen.com/
 */
@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource(name = "wxService")
    private IWXService wxService;

    @RequestMapping(value = "/wx",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public @ResponseBody String wx(HttpServletRequest request) {
        try{
            String echostr = request.getParameter("echostr");//随机字符串

            if (check(request)) {
                return echostr;
            } else  {
                logger.error("===>GET不是来自微信服务器，校验失败!");
            }
        }  catch (Exception e) {
            logger.error("wx get data error!");
        }
        return "error";
    }

    @RequestMapping(value = "/wx",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public @ResponseBody String message(HttpServletRequest request) {
        try{
            if (check(request)) {
                String xml = IOUtils.toString(request.getInputStream(), "UTF-8");
                logger.info("wx data:\n"+xml+"\n");

                String result = wxService.messageHandler(xml);
                return result;
            } else {
                logger.error("===>POST不是来自微信服务器，校验失败!");
            }
        }  catch (Exception e) {
            logger.error("wx post data error!");
        }
        return "error";
    }

    private boolean check(HttpServletRequest request) {
        String signature = request.getParameter("signature");//微信加密签名
        String timestamp = request.getParameter("timestamp");//时间戳
        String nonce = request.getParameter("nonce");//随机数

        return WXUtils.check(signature, timestamp, nonce);
    }
}