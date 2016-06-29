<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>预约排队</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<!-- 避免IE使用兼容模式，IE 运行最新的渲染模式,用 Chrome 框架的页面用webkit 内核-->
	<meta name="renderer" content="webkit">
	<!-- 启用360浏览器的极速模式(webkit) -->
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
	<!-- 初始化移动浏览显示,移动端必须使用 -->
	<meta name="format-detection" content="telephone=no" />
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- 危险勿动 -->
    <script type="text/javascript">
	!function(n){var e=n.document,t=e.documentElement,i=1080,d=i/150,o="orientationchange"in n?"orientationchange":"resize",a=function(){var n=t.clientWidth||320;n>1080&&(n=1080),t.style.fontSize=n/d+"px"};e.addEventListener&&(n.addEventListener(o,a,!1),e.addEventListener("DOMContentLoaded",a,!1))}(window);
	</script>

	<link rel="stylesheet" type="text/css" href="${base}/static/fonts/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base}/static/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${base}/static/mycompass/stylesheets/screen.css">

	<script type="text/javascript" src="${base}/static/js/jquery-1.8.2.min.js"></script>
</head>
<body class="header-padd">
	<div class="content">
		<header class="default-head">
			<a href="javascript:history.go(-1);" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">预约</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="yy-box">
			<dd>
				<span class="yy-tit">预约时间&nbsp;:&nbsp;</span>
				<div class="yy-cont">
					<input type="text" id="time" class="yy-text" placeholder="请输入预约时间">
				</div>
			</dd>
			<dd>
				<span class="yy-tit">人数&nbsp;:&nbsp;</span>
				<div class="yy-cont">
					<input type="text" id="person_num" class="yy-text" placeholder="请输入用餐人数">
				</div>
			</dd>
			<dd>
				<span class="yy-tit">手机号码&nbsp;:&nbsp;</span>
				<div class="yy-cont">
					<input type="text" id="phone" class="yy-text" placeholder="请输入手机号码">
				</div>
			</dd>
			<dd>
				<span class="yy-tit">验证码&nbsp;:&nbsp;</span>
				<div class="yy-cont">
					<input type="text" id="identify" class="yy-text" placeholder="请输入验证码" maxlength="6">
					<input type="button" class="yzmbtn" id="identifying-btn" value="发送验证码">
				</div>
			</dd>
		</dl>
		<div class="default-btn">
			<a href="javascript:void(0);" id="submit">提交</a>
		</div>
	</div>

	<script type="text/javascript" src="${base}/static/js/model.js"></script>
	<script type="text/javascript" src="${base}/static/js/send-identifyingcode.js"></script>
	<script type="text/javascript">
	    $("#submit").click(function(){
	       var time = $("#time").val();
	       var person_num = $("#person_num").val();
	       var phone = $("#phone").val();
	       var identify = $("#identify").val();
	       if(time==""){
	           $.alert("预定时间不能为空");
	           return;
	       }
	       if(!person_num.match(/^\d+$/)){
	           $.alert("人数不能为空且只能为数字");
	           return;
	       }
	       if(!phone.match(/^1[0-9][0-9]\d{8}$/)){
	           $.alert("手机号格式错误");
	           return;
	       }
	       if(identify==""){
	           $.alert("验证码不能为空");
	           return;
	       }
	          $.ajax({
	             url:'json/appointment.action',
	             type:'post',
	             data:{appointdate:time,num:person_num,phone:phone,identify:identify},
	             success:function(data){
	                 json = eval("("+data+")");
	                 if(json.success){
	                    $.alert("正在预定中");
	                    location.href="shop.action";
	                 }else{
	                    $.alert("验证码不正确");
	                }
	             }
	          })
	    })
	    
	    $(".yzmbtn").click(function(){
	       var phone = $("#phone").val();
	        if(!phone.match(/^1[0-9][0-9]\d{8}$/)){
	           $.alert("手机号格式错误");
	           return;
	       }
	       $.ajax({
	           url:'json/appointment!send.action',
	           type:'post',
	           data:{phone:phone},
	           success:function(data){
	                json = eval("("+data+")");
	                if(json.success){
	                   	sendMessage();
	                }
	           }
	       })
	    })
	
	//	$(function(){
	//		$(document).on('click','.qyzmbtn',function(){
	//			sendMessage();
	//		})
	//	})
	</script>
</body>
</html>