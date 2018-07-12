<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
</head>
<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<body>
  <p>您距离2018.01.01日还差<span id="timer"></span></p>
  <a href = "javascript:go();" >点击</a>
</body>
<script type="text/javascript">
function timeFun (year,month,day,hour,minute,second) {
    var leftTime = (new Date(year,month-1,day,hour,minute,second)) - (new Date()); //计算剩余的毫秒数 
    var days = parseInt(leftTime / 1000 / 60 / 60 / 24 , 10); //计算剩余的天数 
    var hours = parseInt(leftTime / 1000 / 60 / 60 % 24 , 10); //计算剩余的小时 
    var minutes = parseInt(leftTime / 1000 / 60 % 60, 10);//计算剩余的分钟 
    var seconds = parseInt(leftTime / 1000 % 60, 10);//计算剩余的秒数 
    document.getElementById("timer").innerHTML = days+"天" + hours+"小时" + minutes+"分"+seconds+"秒"; 
}
setInterval('timeFun(2018,04,08,0,0,0)', 1000)
window.onload = function () {
  timeFun(2017,12,25,0,0,0)
}



var arr = [110,131,101, 122, 12,9,6,44,76,66,2]
console.log(arr.sort())
arr.sort(function (arr1, arr2) {
	// console.log(arr1, arr2)
  console.log(arr1, arr2,arr1-arr2)
  return arr1-arr2
})
console.log(arr)

  function go() {
    var openId="ox4tTwZE9ulbDoywQzSRPrIKLbsA";
    var qrCode="NCT201800000212";
      $.ajax({
          type:'post',
          url:'user/checkCode',
          data:{"openId":openId,"qrCode":qrCode},
          dataType:'json',
          success:function(res){
              if(200 == res.code){
                  window.location.href =  "http://chet.qmcs-china.com/#/carBind?qrCode=" + qrCode;
              }else{
                  alert(res.msg)
                  return;
              }
          },
          error:function () {
              alert("无效二维码");
              return ;
          }
      });
  }
</script>
</html>