<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh">
<jsp:include page="../layout/head.jsp"/>
<style type="text/css">
    .icon16_common{width:16px;height:16px;vertical-align:middle;display:inline-block;line-height:100px;overflow:hidden}.icon16_common.close_gray{background:url("/debug/zh_CN/htmledition/style/page/page_debug_z.png") 0 0 no-repeat}.icon16_common.close_gray:hover{background:url("/debug/zh_CN/htmledition/style/page/page_debug_z.png") 0 -26px no-repeat}h1{margin:20px 35px;border-bottom:1px dashed #ecede8;font-size:16px;color:#333;font-weight:normal;height:30px;line-height:30px;position:relative;clear:both}body{margin:0;font-family:"Microsoft Yahei","Tahoma",Arial;font-size:14px;color:#333;background-color:#FFF}ul{list-style-type:none;margin:0;padding:0}pre{margin:0}.head_box{position:relative;background-color:#f3f3f3;box-shadow:0 2px 4px rgba(0,0,0,0.15),inset 0 -1px 0 0 #fcfcfc;-moz-box-shadow:0 2px 4px rgba(0,0,0,0.15),inset 0 -1px 0 0 #fcfcfc;-webkit-box-shadow:0 2px 4px rgba(0,0,0,0.15),inset 0 -1px 0 0 #fcfcfc;border-top:4px solid #67ad03;border-bottom:1px solid #bdbdbd}.head_box .inner.wrp{width:960px;margin-left:auto;margin-right:auto}.logo{padding-top:10px;padding-bottom:10px;font-size:24px}.logo a{display:block;width:248px;height:40px;overflow:hidden;text-decoration:none;background:transparent url(/debug/zh_CN/htmledition/images/bg/bg_logo193ff1.png) no-repeat 0 0}.main{width:600px;min-height:400px;border-left:1px solid #ecede8;border-right:1px solid #ecede8;border-bottom:1px solid #ecede8}.main .panel{padding:0 35px}.submit{margin-left:139px;display:inline-block;overflow:visible;padding:0 40px;height:30px;line-height:30px;vertical-align:middle;text-align:center;text-decoration:none;color:#fff;border-radius:3px;-moz-border-radius:3px;-webkit-border-radius:3px;font-size:14px;border:1px solid #3d810c;cursor:pointer;background-color:#56a447;background-image:-moz-linear-gradient(top,#60b452 0,#56a447 100%);background-image:-webkit-gradient(linear,0 0,0 100%,from(#60b452),to(#56a447));background-image:-webkit-linear-gradient(top,#60b452 0,#56a447 100%);background-image:-o-linear-gradient(top,#60b452 0,#56a447 100%);background-image:linear-gradient(to bottom,#60b452 0,#56a447 100%)}.unsubmit{margin-left:139px;display:inline-block;overflow:visible;padding:0 40px;height:30px;line-height:30px;color:#000;font-size:14px;text-align:center;vertical-align:middle;text-decoration:none;margin-top:6px;border:1px solid #bebebe;border-radius:3px;-moz-border-radius:3px;-webkit-border-radius:3px;box-shadow:0 1px 1px #dddedb;background-color:#e4e4e4;background:-webkit-gradient(linear,left top,left bottom,from(#f8f8f8),to(#d5d5d5),color-stop(0.1,#f1f1f1),color-stop(0.5,#e4e4e4),color-stop(0.9,#d7d7d7),color-stop(1,#d5d5d5));background-image:-moz-linear-gradient(top,#f1f1f1 10%,#e4e4e4 50%,#d7d7d7 90%,#d5d5d5 100%)}.submit:hover{background-color:#53a046;background-image:-moz-linear-gradient(top,#5aab4d 0,#4f9841 100%);background-image:-webkit-gradient(linear,0 0,0 100%,from(#5aab4d),to(#4f9841));background-image:-webkit-linear-gradient(top,#5aab4d 0,#4f9841 100%);background-image:-o-linear-gradient(top,#5aab4d 0,#4f9841 100%);background-image:linear-gradient(to bottom,#5aab4d 0,#4f9841 100%);box-shadow:0 1px 2px rgba(0,0,0,0.3);-moz-box-shadow:0 1px 2px rgba(0,0,0,0.3);-webkit-box-shadow:0 1px 2px rgba(0,0,0,0.3)}iframe{width:100%;padding:1px;height:400px\9;overflow:hidden;margin:0 auto;margin-top:20px;border:0}.des{text-align:center;border:1px solid #aaa;background-color:#f9f9f9;padding:5px;font-size:95%;margin-bottom:.5em;margin-left:0;margin-right:0}.resultContainer .bannerDiv{position:relative;margin:0 -15px 15px;padding:0;font-size:16px;border-bottom:1px solid #d9d9d9}.resultContainer .banner{display:block;margin-right:0;padding:0 15px;height:40px;line-height:40px}.resultContainer .closeButton{position:absolute;top:7px;right:15px;display:block;width:23px;height:23px}.resultContainer .banner_active{background-color:#d0d0d0}.result{width:858px}.resultContainer,.content{padding:10px 15px;border:1px solid #ccc;color:#333;background-color:#f8f8f8;border-radius:3px;margin-bottom:20px}.resultContainer{padding:0 15px 10px}#request_url{display:block;word-break:break-all;word-wrap:break-word}.result ul li{word-break:break-all;word-wrap:break-word}.result ul li .CodeContainer{font-family:"Microsoft Yahei","Tahoma",Arial;font-size:14px;color:#333}.result ul li .CodeContainer .PropertyName{color:#0000d6}.result ul li .CodeContainer .Number,.result ul li .CodeContainer .String{color:#ff9b05}.result ul.hint{padding:0}.resultContainer a{text-decoration:none;color:black}.result .body{padding-bottom:15px}.result .hint{margin-top:15px}.result dl{display:block;*width:857px;padding:0 0 10px;margin:0 0 15px;border-bottom:1px solid #d9d9d9}.result dl.hint{border:0}.result dl dt{float:left;color:#777}.result dl .content{padding:0;border:0}.result dl dd.content{margin-left:86px;margin-bottom:0}.frm_control_group{margin-bottom:20px}.frm_control_group label{margin-right:38px;display:inline-block;vertical-align:top;*display:inline;zoom:1}.name{display:inline-block;*display:inline;zoom:1;width:125px}.inputDiv span{vertical-align:top}.manual{padding:0}.manual li{margin-top:10px;list-style:none}.manual li b{font-weight:bold}.frm_label{float:left;margin-right:5px}.frm_controls{overflow:hidden}.frm_input_box{display:inline-block;*display:inline;zoom:1;line-height:30px;vertical-align:middle;border:1px solid #b3b3b3;box-shadow:inset 0 1px 1px rgba(0,0,0,0.15);-moz-box-shadow:inset 0 1px 1px rgba(0,0,0,0.15);-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,0.15);border-radius:3px;-moz-border-radius:3px;-webkit-border-radius:3px;background-color:#fff}.frm_tips{color:#a3a3a3}.red{color:red}.hide{display:none}.green{color:green}.textareaDiv span{vertical-align:top}#formSelector{min-width:330px}.frm_tips{display:inline-block;*display:inline;zoom:1;margin-left:5px}.inputDiv select,.inputDiv input[type="text"],.inputDiv input[type="file"]{width:200px}.inputDiv .tips{display:block;margin-left:139px;color:#a3a3a3}.inputDiv .errMsg{display:block;margin-left:139px;*margin-top:-18px}.get-value{display:-moz-inline-box;display:inline-block;*display:inline;zoom:1;white-space:pre-wrap;word-wrap:break-word;width:200px;margin-right:20px}.result_content .title{font-weight:bold;font-size:12px}.footer{text-align:center;color:#516e81;margin:25px auto 60px;font-size:12px;height:49px;line-height:20px;text-shadow:0 1px 0 #fff}.footer ul{text-align:center;list-style:none;margin:0;padding:0}.footer li{display:inline}.footer a{color:#3a8dc9;margin:0 5px;text-decoration:none}
</style>
<body>
  <div class="container">
    <jsp:include page="../layout/top.jsp"/>
      <div class="main" id="main">
          <h1>微信公众平台接口调试工具</h1>
          <div class="content" id="content">
              <div class="frm_control_group" id="formContent"><label>参数列表：</label><br><br>
                  <div id="formContainer">
                      <form action="/wx" method="POST">
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">URL : </span>
                              <input type="text" required="true" name="URL">
                              <span class="tips">开发者填写URL，调试时将把消息推送到该URL上</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">ToUserName : </span>
                              <input type="text" required="true" name="ToUserName">
                              <span class="tips">开发者微信号</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">FromUserName : </span>
                              <input type="text" required="true" name="FromUserName">
                              <span class="tips">发送方帐号（一个OpenID）</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">CreateTime : </span>
                              <input type="text" required="true" name="CreateTime">
                              <span class="tips">消息创建时间 （整型）</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">MsgType : </span>
                              <input type="text" readonly="true" disabled="true" value="text" required="true" name="MsgType">
                              <span class="tips">消息类型（文本消息为 text ）</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">Content : </span>
                              <input type="text" required="true" name="Content">
                              <span class="tips">消息类型（文本消息内容）</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <div class="inputDiv">
                              <span class="red">*</span>
                              <span class="name">MsgId : </span>
                              <input type="text" required="true" name="MsgId">
                              <span class="tips">消息类型（消息id，64位整型）</span>
                              <span class="errMsg"></span>
                              <br>
                          </div>
                          <input type="submit" value="submit" id="submit" class="unsubmit">
                      </form>
                  </div>
              </div>
          </div>
      </div>

    <jsp:include page="../layout/footer.jsp"/>
  </div>
</body>
</html>
