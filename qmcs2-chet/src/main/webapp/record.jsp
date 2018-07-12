<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>扫一扫</title>
</head>

<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>


<script type="text/javascript">
$(function() {
    var timestamp = $("#timestamp").val();//时间戳
    var nonceStr = $("#noncestr").val();//随机串
    var signature = $("#signature").val();//签名
    var appId = $("#appId").val();//签名
    
    wx.config({
        debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId : appId, // 必填，公众号的唯一标识
        timestamp : timestamp, // 必填，生成签名的时间戳
        nonceStr : nonceStr, // 必填，生成签名的随机串
        signature : signature,// 必填，签名，见附录1
        jsApiList : [ 'scanQRCode' ]
    // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    
});
    wx.ready(function(){
    	scanQRCode();
    });
    wx.error(function(res){
        alert("打开摄像头失败");
    });

   function scanQRCode(){
         wx.scanQRCode({
             desc: 'scanQRCode desc',
             needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
             scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
             success: function (res) {
                 // 回调
                 // var redirectUrl = $("#redirectUrl").val();//签名
                 var openId = $("#openId").val();// openId
                 var codeStr = res.resultStr;
                 var arr = codeStr.split("code=")[1];
                 if (typeof(arr) == "undefined"){
                     alert("无效二维码");
                     return;
                 }
                 var qrCode = arr.substring(0,15);
                 if(qrCode.indexOf("NCT") == -1){
                     alert("无效二维码");
                     return;
                 }
                 window.location.href = "http://chet.qmcs-china.com/#/scanResult?qrCode=" + qrCode + "&openId="+openId;
             },
             error: function(res){
                 if(res.errMsg.indexOf('function_not_exist') > 0){
                     alert('版本过低请升级');
                 }
             }
         });
    }


</script>
<body>
<input id="appId" type="hidden" value="${appId}" />
<input id="timestamp" type="hidden" value="${timestamp}" />
<input id="noncestr" type="hidden" value="${nonceStr}" />
<input id="signature" type="hidden" value="${signature}" />
<input id="openId" type="hidden" value="${openId}" />
</body>

</html>