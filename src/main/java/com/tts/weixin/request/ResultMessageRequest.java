package com.tts.weixin.request;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局返回码说明.
 * User: eric
 * Date: 13-11-23
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public class ResultMessageRequest {
    public final static Map<String ,String> MESSAGE = new HashMap<String, String>();
    public final static Map<String ,Integer> LIMIT = new HashMap<String, Integer>();//接口频率限制

    static {
        LIMIT.put("access_token",2000);//获取access_token
        LIMIT.put("menu_create",1000);//自定义菜单创建
        LIMIT.put("menu_query",10000);//自定义菜单查询
        LIMIT.put("menu_delete",1000);//自定义菜单删除
        LIMIT.put("group_create",1000);//创建分组
        LIMIT.put("group_get",1000);//获取分组
        LIMIT.put("group_rename",1000);//修改分组名
        LIMIT.put("group_move",100000);//移动用户分组
        LIMIT.put("media_upload",5000);//上传多媒体文件
        LIMIT.put("media_download",10000);//下载多媒体文件
        LIMIT.put("send_CS",500000);//发送客服消息
        LIMIT.put("RQ_param",1000);//获取带参数的二维码	 临时二维码无限，永久二维码1000个
        LIMIT.put("fllowers_get",500);//获取关注者列表
        LIMIT.put("user_info",5000000);//获取用户基本信息
        LIMIT.put("access_token_authorize_get",2000000);//获取网页授权access_token
        LIMIT.put("access_token_authorize_refresh",2000000);//刷新网页授权access_token
        LIMIT.put("user_info_authorize_get",2000000);//网页授权获取用户信息

        MESSAGE.put("-1", "系统繁忙");
        MESSAGE.put("0", "请求成功");
        MESSAGE.put("40001", "获取access_token时AppSecret错误，或者access_token无效");
        MESSAGE.put("40002", "不合法的凭证类型");
        MESSAGE.put("40003", "不合法的OpenID");
        MESSAGE.put("40004", "不合法的媒体文件类型");
        MESSAGE.put("40005", "不合法的文件类型");
        MESSAGE.put("40006", "不合法的文件大小");
        MESSAGE.put("40007", "不合法的媒体文件id");
        MESSAGE.put("40008", "不合法的消息类型");
        MESSAGE.put("40009", "不合法的图片文件大小");
        MESSAGE.put("40010", "不合法的语音文件大小");
        MESSAGE.put("40011", "不合法的视频文件大小");
        MESSAGE.put("40012", "不合法的缩略图文件大小");
        MESSAGE.put("40013", "不合法的APPID");
        MESSAGE.put("40014", "不合法的access_token");
        MESSAGE.put("40015", "不合法的菜单类型");
        MESSAGE.put("40016", "不合法的按钮个数");
        MESSAGE.put("40017", "不合法的按钮个数");
        MESSAGE.put("40018", "不合法的按钮名字长度");
        MESSAGE.put("40019", "不合法的按钮KEY长度");
        MESSAGE.put("40020", "不合法的按钮URL长度");
        MESSAGE.put("40021", "不合法的菜单版本号");
        MESSAGE.put("40022", "不合法的子菜单级数");
        MESSAGE.put("40023", "不合法的子菜单按钮个数");
        MESSAGE.put("40024", "不合法的子菜单按钮类型");
        MESSAGE.put("40025", "不合法的子菜单按钮名字长度");
        MESSAGE.put("40026", "不合法的子菜单按钮KEY长度");
        MESSAGE.put("40027", "不合法的子菜单按钮URL长度");
        MESSAGE.put("40028", "不合法的自定义菜单使用用户");
        MESSAGE.put("40029", "不合法的oauth_code");
        MESSAGE.put("40030", "不合法的refresh_token");
        MESSAGE.put("40031", "不合法的openid列表");
        MESSAGE.put("40032", "不合法的openid列表长度");
        MESSAGE.put("40033", "不合法的请求字符，不能包含\\uxxxx格式的字符");
        MESSAGE.put("40035", "不合法的参数");
        MESSAGE.put("40038", "不合法的请求格式");
        MESSAGE.put("40039", "不合法的URL长度");
        MESSAGE.put("40050", "不合法的分组id");
        MESSAGE.put("40051", "分组名字不合法");
        MESSAGE.put("41001", "缺少access_token参数");
        MESSAGE.put("41002", "缺少appid参数");
        MESSAGE.put("41003", "缺少refresh_token参数");
        MESSAGE.put("41004", "缺少secret参数");
        MESSAGE.put("41005", "缺少多媒体文件数据");
        MESSAGE.put("41006", "缺少media_id参数");
        MESSAGE.put("41007", "缺少子菜单数据");
        MESSAGE.put("41008", "缺少oauth code");
        MESSAGE.put("41009", "缺少openid");
        MESSAGE.put("42001", "access_token超时");
        MESSAGE.put("42002", "refresh_token超时");
        MESSAGE.put("42003", "oauth_code超时");
        MESSAGE.put("43001", "需要GET请求");
        MESSAGE.put("43002", "需要POST请求");
        MESSAGE.put("43003", "需要HTTPS请求");
        MESSAGE.put("43004", "需要接收者关注");
        MESSAGE.put("43005", "需要好友关系");
        MESSAGE.put("44001", "多媒体文件为空");
        MESSAGE.put("44002", "POST的数据包为空");
        MESSAGE.put("44003", "图文消息内容为空");
        MESSAGE.put("44004", "文本消息内容为空");
        MESSAGE.put("45001", "多媒体文件大小超过限制");
        MESSAGE.put("45002", "消息内容超过限制");
        MESSAGE.put("45003", "标题字段超过限制");
        MESSAGE.put("45004", "描述字段超过限制");
        MESSAGE.put("45005", "链接字段超过限制");
        MESSAGE.put("45006", "图片链接字段超过限制");
        MESSAGE.put("45007", "语音播放时间超过限制");
        MESSAGE.put("45008", "图文消息超过限制");
        MESSAGE.put("45009", "接口调用超过限制");
        MESSAGE.put("45010", "创建菜单个数超过限制");
        MESSAGE.put("45015", "回复时间超过限制");
        MESSAGE.put("45016", "系统分组，不允许修改");
        MESSAGE.put("45017", "分组名字过长");
        MESSAGE.put("45018", "分组数量超过上限");
        MESSAGE.put("46001", "不存在媒体数据");
        MESSAGE.put("46002", "不存在的菜单版本");
        MESSAGE.put("46003", "不存在的菜单数据");
        MESSAGE.put("46004", "不存在的用户");
        MESSAGE.put("47001", "解析JSON/XML内容错误");
        MESSAGE.put("48001", "api功能未授权");
        MESSAGE.put("50001", "用户未授权该api");
    }
}